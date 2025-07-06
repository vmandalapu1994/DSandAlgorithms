package MergeIntervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @see <a href="https://leetcode.com/problems/merge-intervals/description/">Merge Intervals</a>
 */
public class NonOverlappingInterval1 {

    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]);
        });

        List<int[]> nonOverlapIntervals = new ArrayList<>();

        for (int[] interval : intervals) {
            if (nonOverlapIntervals.isEmpty()) {
                nonOverlapIntervals.add(interval);
                continue;
            }

            int[] prev = nonOverlapIntervals.get(nonOverlapIntervals.size() - 1);

            // non overlapping
            if (interval[0] > prev[1]) {
                nonOverlapIntervals.add(interval);
            } else {
                prev[1] = Math.max(prev[1], interval[1]);
            }
        }

        return nonOverlapIntervals.toArray(new int[0][]);

    }
}
