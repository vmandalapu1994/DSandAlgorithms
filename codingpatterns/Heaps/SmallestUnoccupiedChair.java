package Heaps;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @see <a href="https://leetcode.com/problems/the-number-of-the-smallest-unoccupied-chair/">The Number of the Smallest Unoccupied Chair</a>
 */
public class SmallestUnoccupiedChair {

    public int smallestChair(int[][] times, int targetFriend) {
        int[][] arrivalQueue = new int[times.length][3];
        for (int i = 0; i < times.length; i++) {
            arrivalQueue[i][0] = times[i][0]; //start time
            arrivalQueue[i][1] = times[i][1]; //end time
            arrivalQueue[i][2] = i; // Index
        }
        Arrays.sort(arrivalQueue, (a, b) -> Integer.compare(a[0], b[0]));
        PriorityQueue<int[]> occupiedQueue = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        PriorityQueue<Integer> vacantChairs = new PriorityQueue<>();
        for (int i = 0; i < times.length; i++) {
            vacantChairs.add(i);
        }
        int vacant = -1;
        for (int i = 0; i < arrivalQueue.length; i++) {
            int[] entry = arrivalQueue[i];
            while (!occupiedQueue.isEmpty() && occupiedQueue.peek()[1] <= entry[0]) {
                int[] occupiedEntry = occupiedQueue.poll();
                vacantChairs.add(occupiedEntry[0]);
            }
            vacant = vacantChairs.poll();
            occupiedQueue.add(new int[]{vacant, entry[1]});
            if (entry[2] == targetFriend) {
                break;
            }
        }
        return vacant;
    }
}
