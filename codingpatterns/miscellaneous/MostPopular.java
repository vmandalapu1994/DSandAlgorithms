package miscellaneous;

import java.util.*;

/**
 * Given a stream of contentIds with increase/decrease of popularity, find the most popular content Id.
 */
class MostPopular {

    Map<Integer, Integer> contentMap;

    TreeMap<Integer, Set<Integer>> popularityMap;

    public MostPopular() {
        this.contentMap = new HashMap<>();
        this.popularityMap = new TreeMap<>(Comparator.reverseOrder());
    }

    // Time complexity: O(logn)
    void increasePopularity(Integer contentId) {
        contentMap.putIfAbsent(contentId, 0);
        Integer prevCount = contentMap.get(contentId);
        int newCount = contentMap.get(contentId) + 1;
        contentMap.put(contentId, newCount);
        if (popularityMap.containsKey(prevCount)) {
            popularityMap.get(prevCount).remove(contentId);
            if (popularityMap.get(prevCount).isEmpty()) {
                popularityMap.remove(prevCount);
            }
        }
        popularityMap.putIfAbsent(newCount, new HashSet<>());
        popularityMap.get(newCount).add(contentId);
    }

    //Time complexity: O(1)
    Integer mostPopular() {
        if (popularityMap == null || popularityMap.isEmpty()) {
            return -1;
        }
        Set<Integer> contentIds = popularityMap.firstEntry().getValue();
        return contentIds != null && !contentIds.isEmpty() ? contentIds.iterator().next() : -1;
    }

    // Time complexity: O(logn)
    void decreasePopularity(Integer contentId) {
        if (!contentMap.containsKey(contentId)) {
            return;
        }
        Integer prevCount = contentMap.get(contentId);
        int newCount = contentMap.get(contentId) - 1;
        contentMap.put(contentId, newCount);
        if (popularityMap.containsKey(prevCount)) {
            popularityMap.get(prevCount).remove(contentId);
            if (popularityMap.get(prevCount).isEmpty()) {
                popularityMap.remove(prevCount);
            }
        }
        if (newCount != 0) {
            popularityMap.putIfAbsent(newCount, new HashSet<>());
            popularityMap.get(newCount).add(contentId);
        }
    }

    public static void main(String[] args) {
        MostPopular popularityTracker = new MostPopular();

        popularityTracker.increasePopularity(7);
        popularityTracker.increasePopularity(7);
        popularityTracker.increasePopularity(8);
        System.out.println(popularityTracker.mostPopular());        // returns 7
        popularityTracker.increasePopularity(8);
        System.out.println(popularityTracker.mostPopular());        // returns 7
        popularityTracker.increasePopularity(8);
        System.out.println(popularityTracker.mostPopular());        // returns 8
        popularityTracker.decreasePopularity(8);
        popularityTracker.decreasePopularity(8);
        System.out.println(popularityTracker.mostPopular());        // returns 7
        popularityTracker.decreasePopularity(7);
        popularityTracker.decreasePopularity(7);
        popularityTracker.decreasePopularity(8);
        System.out.println(popularityTracker.mostPopular());    // returns -1
    }

}

