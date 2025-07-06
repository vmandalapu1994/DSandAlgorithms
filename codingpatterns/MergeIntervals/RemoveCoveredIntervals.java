package MergeIntervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @see <a href="https://leetcode.com/problems/remove-covered-intervals/">Remove Covered Intervals</a>
 */
public class RemoveCoveredIntervals {


    public int removeCoveredIntervals(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(b[1], a[1]);
        });

        List<int[]> notCovered = new ArrayList<>();

        for (int[] i : intervals) {
            if (notCovered.isEmpty()) {
                notCovered.add(i);
            } else {
                int[] last = notCovered.get(notCovered.size() - 1);
                if (last[0] <= i[0] && last[1] >= i[1]) {
                    continue;
                }
                notCovered.add(i);
            }
        }

        return notCovered.size();

    }


}
