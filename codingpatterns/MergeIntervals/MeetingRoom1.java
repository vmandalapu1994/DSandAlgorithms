package MergeIntervals;

import java.util.*;

/**
 * Problem statement:
 * <p>
 * You are given an array of meeting times, intervals, where each interval consists of a pair of start and end times, identify whether or not a person can attend all the meetings.
 * <p>
 * An important thing to note here is that the specified end time for each meeting is exclusive.
 */

public class MeetingRoom1 {

    public static boolean attendAllMeetings(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]);
        });

        int[] prev = null;

        for (int[] p : intervals) {
            if (prev != null) {
                if (prev[1] > p[0]) {
                    return false;
                }
            }
            prev = p;
        }

        return true;
    }
}