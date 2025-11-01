package miscellaneous;

import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

class InMemoryKeyValueStore {

    private final Map<String, Value> store;
    private final Map<Long, Set<String>> expiryMap;

    private volatile boolean running = true;

    public InMemoryKeyValueStore() {
        this.store = new ConcurrentHashMap<>();
        this.expiryMap = new ConcurrentSkipListMap<>();
        Thread cleanUpThread = new Thread(this::cleanupJob, "InMemoryStore-CleanupThread");
        cleanUpThread.setDaemon(true);
        cleanUpThread.start();
    }

    public void save(String key, String value, Long ttlInMilliSeconds) {
        Long currentTime = System.currentTimeMillis();
        Long expiryTime = currentTime + ttlInMilliSeconds;
        Value valueWithExpiry = store.get(key);
        if (valueWithExpiry != null) {
            Long oldExpiry = valueWithExpiry.getExpiryTime();
            valueWithExpiry.setValue(value);
            valueWithExpiry.setExpiryTime(expiryTime);
            Set<String> oldKeys = expiryMap.get(oldExpiry);
            if (oldKeys != null) {
                oldKeys.remove(key);
                if (oldKeys.isEmpty()) {
                    expiryMap.remove(oldExpiry);
                }
            }
        } else {
            store.put(key, new Value(value, expiryTime));
        }
        expiryMap.computeIfAbsent(expiryTime, k -> ConcurrentHashMap.newKeySet()).add(key);
    }

    public Optional<String> get(String key) {
        Value value = store.get(key);
        if (value == null) {
            return Optional.empty();
        }
        if (value.getExpiryTime() > System.currentTimeMillis()) {
            return Optional.of(value.getValue());
        } else {
            store.remove(key);
            expiryMap.get(value.getExpiryTime()).remove(key);
        }
        return Optional.empty();
    }

    // cron job which runs at regular intervals of 5 secs
    public void cleanupJob() {
        while (running) {
            cleanUp();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException exc) {
                Thread.currentThread().interrupt();
            }
        }
    }


    public void cleanUp() {
        Long currentTime = System.currentTimeMillis();
        ConcurrentNavigableMap<Long, Set<String>> expiredEntryMap = ((ConcurrentSkipListMap<Long, Set<String>>) expiryMap).headMap(currentTime, true);
        for (Map.Entry<Long, Set<String>> entry : expiredEntryMap.entrySet()) {
            Set<String> expiredKeys = expiryMap.remove(entry.getKey());
            expiredKeys.forEach(store::remove);
        }
    }

    public void stopCleanUpThread() {
        this.running = false;
    }

    public static class Value {
        private String value;
        private Long expiryTimeInEpochMillis;

        public Value(String value, Long expiryTimeInEpoch) {
            this.value = value;
            this.expiryTimeInEpochMillis = expiryTimeInEpoch;
        }

        public String getValue() {
            return this.value;
        }

        public Long getExpiryTime() {
            return this.expiryTimeInEpochMillis;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public void setExpiryTime(Long expiryTime) {
            this.expiryTimeInEpochMillis = expiryTime;
        }

    }

}