package Heaps;

import java.util.PriorityQueue;

/**
 * @see <a href="https://leetcode.com/problems/longest-happy-string/">Longest Happy String</a>
 */
public class LongestHappyString {

    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<PQEntry> queue = new PriorityQueue<>((e1, e2) -> Integer.compare(e2.count, e1.count));
        if (a > 0) {
            queue.add(new PQEntry('a', a));
        }
        if (b > 0) {
            queue.add(new PQEntry('b', b));
        }
        if (c > 0) {
            queue.add(new PQEntry('c', c));
        }
        StringBuilder result = new StringBuilder();
        while (!queue.isEmpty()) {
            PQEntry entry1 = queue.poll();
            char ch1 = entry1.ch;
            // If the current charcter occured 2 times already in sequence then poll next frequent entry and process it.
            if (result.length() >= 2 && result.charAt(result.length() - 1) == ch1 && result.charAt(result.length() - 2) == ch1) {
                if (queue.isEmpty()) {
                    break;
                }
                PQEntry entry2 = queue.poll();
                char ch2 = entry2.ch;
                result.append(ch2);
                if (entry2.count - 1 > 0) {
                    queue.add(new PQEntry(ch2, entry2.count - 1));
                }
                queue.add(entry1);
            } else {
                result.append(ch1);
                if (entry1.count - 1 > 0) {
                    queue.add(new PQEntry(ch1, entry1.count - 1));
                }
            }
        }
        return result.toString();
    }

    private static class PQEntry {
        char ch;
        int count;

        PQEntry(char ch, int count) {
            this.ch = ch;
            this.count = count;
        }
    }
}
