package MergeIntervals;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @see <a href="https://www.interviewbit.com/problems/meeting-rooms/">Meeting rooms</a>
 */
public class MeetingRoom2 {

    public int solveOptimized(ArrayList<ArrayList<Integer>> A) {

        A.sort((a, b) -> {
            if (a.get(0) != b.get(0)) {
                return Integer.compare(a.get(0), b.get(0));
            }
            return Integer.compare(a.get(1), b.get(1));
        });

        PriorityQueue<Integer> rooms = new PriorityQueue<>();

        for (ArrayList<Integer> i : A) {
            if (!rooms.isEmpty() && rooms.peek() <= i.get(0)) {
                rooms.poll();
                rooms.add(i.get(1));
            } else {
                rooms.add(i.get(1));
            }
        }

        return rooms.size();

    }

    public int solve(ArrayList<ArrayList<Integer>> A) {

        A.sort((a, b) -> {
            if (a.get(0) != b.get(0)) {
                return Integer.compare(a.get(0), b.get(0));
            }
            return Integer.compare(a.get(1), b.get(1));
        });

        List<int[]> rooms = new ArrayList<>();

        for (ArrayList<Integer> i : A) {
            boolean canSchedule = false;

            for (int[] last : rooms) {
                if (last[1] <= i.get(0)) {
                    last[0] = i.get(0);
                    last[1] = i.get(1);
                    canSchedule = true;
                    break;
                }
            }

            if (!canSchedule) {
                rooms.add(new int[]{i.get(0), i.get(1)});
            }

        }

        return rooms.size();

    }

}
