package MergeIntervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @see <a href="https://leetcode.com/problems/count-days-without-meetings/description/">Count Days Without Meetings</a>
 */

public class CountDaysWithoutMeetings {

    public int countDays(int days, int[][] meetings) {

        Arrays.sort(meetings, (a, b) -> {
            return Integer.compare(a[0], b[0]);
        });

        List<int[]> nonOverlapping = new ArrayList<>();

        for (int[] meet : meetings) {
            int[] prev = nonOverlapping.isEmpty() ? null : nonOverlapping.get(nonOverlapping.size() - 1);

            if (prev != null && prev[1] >= meet[0]) {
                prev[1] = Math.max(prev[1], meet[1]);
            } else {
                nonOverlapping.add(meet);
            }
        }

        int noMeet = 0;

        int[] prev = null;

        for (int[] i : nonOverlapping) {
            if (prev == null) {
                noMeet += i[0] - 1;
            } else if (i[0] - prev[1] - 1 > 0) {
                // both i[0] and prev[1] are inclusive
                noMeet += i[0] - prev[1] - 1;
            }
            prev = i;
        }

        // Here last day is not inclusive so only taking days-prev[1].
        noMeet += days - prev[1] > 0 ? days - prev[1] : 0;

        return noMeet;
    }
}
