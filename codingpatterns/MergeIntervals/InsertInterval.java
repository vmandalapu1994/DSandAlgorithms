package MergeIntervals;

import java.util.ArrayList;
import java.util.List;

/**
 * @see <a href="https://leetcode.com/problems/insert-interval/">Insert Interval</a>
 */
public class InsertInterval {

    public int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> output = new ArrayList<>();

        int i = 0, n = intervals.length;

        // Before newInterval
        while (i < n && intervals[i][1] < newInterval[0]) {
            output.add(intervals[i]);
            i++;
        }

        // Overlapping intervals
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }

        output.add(newInterval);

        // After newInterval
        while (i < n) {
            output.add(intervals[i]);
            i++;
        }

        return output.toArray(new int[0][]);
    }

}
