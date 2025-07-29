package Heaps;

import java.util.PriorityQueue;

/**
 * @see <a href="https://www.geeksforgeeks.org/problems/minimum-cost-of-ropes-1587115620/1">Minimum Cost of ropes</a>
 */
public class MinCostToConnectRopes {

    public static int minCost(int[] arr) {
        if (arr.length == 1) {
            return 0;
        }
        PriorityQueue<Integer> costHeap = new PriorityQueue<>();
        int totalCost = 0;
        for (int i : arr) {
            costHeap.add(i);
        }

        while (costHeap.size() > 1) {
            int first = costHeap.poll();
            int second = costHeap.poll();

            totalCost += (first + second);
            costHeap.add(first + second);
        }

        return totalCost;
    }

}
