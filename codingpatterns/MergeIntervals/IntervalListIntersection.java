package MergeIntervals;

import java.util.ArrayList;
import java.util.List;

/**
 * @see <a href="https://leetcode.com/problems/interval-list-intersections/">Interval List Intersections</a>
 */
public class IntervalListIntersection {

    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {

        List<int[]> output = new ArrayList<>();

        int m = firstList.length;
        int n = secondList.length;

        for (int i = 0, j = 0; i < m && j < n; ) {
            // If there is a overlap, there is a valid intersection.
            int start = Math.max(firstList[i][0], secondList[j][0]);
            int end = Math.min(firstList[i][1], secondList[j][1]);
            if (start <= end) {
                output.add(new int[]{start, end});
            }
            if (firstList[i][1] < secondList[j][1]) {
                i++;
            } else {
                j++;
            }
        }

        return output.toArray(new int[0][]);
    }

}
