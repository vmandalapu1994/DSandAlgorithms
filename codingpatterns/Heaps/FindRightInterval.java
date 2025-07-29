package Heaps;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @see <a href="https://leetcode.com/problems/find-right-interval/">Find Right Interval</a>
 */

public class FindRightInterval {

    public int[] findRightInterval(int[][] intervals) {

        PriorityQueue<PQEntry> minStart = new PriorityQueue<>((a, b) -> Integer.compare(a.start, b.start));

        PriorityQueue<PQEntry> minEnd = new PriorityQueue<>((a, b) -> Integer.compare(a.end, b.end));

        for (int i = 0; i < intervals.length; i++) {
            minStart.add(new PQEntry(i, intervals[i][0], intervals[i][1]));
        }

        int[] rightIndex = new int[intervals.length];

        Arrays.fill(rightIndex, -1);

        while (!minStart.isEmpty()) {
            PQEntry entry = minStart.poll();
            while (!minEnd.isEmpty() && minEnd.peek().end <= entry.start) {
                PQEntry entry1 = minEnd.poll();
                rightIndex[entry1.index] = entry.index;
            }
            if (entry.end == entry.start) {
                rightIndex[entry.index] = entry.index;
            } else {
                minEnd.add(entry);
            }
        }

        return rightIndex;

    }

    private static class PQEntry {

        int index;

        int start;

        int end;

        PQEntry(int index, int start, int end) {
            this.index = index;
            this.start = start;
            this.end = end;
        }
    }

}
