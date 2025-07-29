package Heaps;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @see <a href="https://leetcode.com/problems/meeting-rooms-iii/">Meeting Rooms III</a>
 */

public class MeetingRooms3 {

    public int mostBooked(int n, int[][] meetings) {

        int max = 0;

        int roomNum = Integer.MAX_VALUE;

        int[] taskCount = new int[n];

        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));

        // When there are no rooms available and 2 rooms have same end time then we want to poll the lowest room num.
        PriorityQueue<PQEntry> occupiedRooms = new PriorityQueue<>((a, b) -> {
            if (a.endTime != b.endTime) {
                return Long.compare(a.endTime, b.endTime);
            }
            return Integer.compare(a.roomNum, b.roomNum);
        });

        PriorityQueue<PQEntry> vacantRooms = new PriorityQueue<>((a, b) -> Integer.compare(a.roomNum, b.roomNum));

        for (int i = 0; i < n; i++) {
            vacantRooms.add(new PQEntry(i, 0));
        }

        for (int[] meet : meetings) {
            while (!occupiedRooms.isEmpty() && occupiedRooms.peek().endTime <= meet[0]) {
                PQEntry entry = occupiedRooms.poll();
                vacantRooms.add(new PQEntry(entry.roomNum, 0));
            }
            if (vacantRooms.isEmpty()) {
                PQEntry entry = occupiedRooms.poll();
                occupiedRooms.add(new PQEntry(entry.roomNum, entry.endTime + (long) (meet[1] - meet[0])));
                taskCount[entry.roomNum]++;
            } else {
                PQEntry entry = vacantRooms.poll();
                occupiedRooms.add(new PQEntry(entry.roomNum, meet[1]));
                taskCount[entry.roomNum]++;
            }

        }

        for (int i = 0; i < taskCount.length; i++) {
            System.out.print(i + "->" + taskCount[i] + ",");
            if (max == taskCount[i]) {
                if (roomNum > i) {
                    roomNum = i;
                }
            } else if (taskCount[i] > max) {
                roomNum = i;
                max = taskCount[i];
            }
        }

        return roomNum;
    }

    private static class PQEntry {

        int roomNum;

        // using long to avoid integer overflow as the number of meetings * duration can go beyond integer limits.
        long endTime;

        PQEntry(int roomNum, long endTime) {
            this.roomNum = roomNum;
            this.endTime = endTime;
        }

    }

}
