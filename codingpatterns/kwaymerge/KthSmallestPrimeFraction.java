package kwaymerge;

import java.util.PriorityQueue;

/**
 * @see <a href="https://leetcode.com/problems/k-th-smallest-prime-fraction/">K-th Smallest Prime Fraction</a>
 */
public class KthSmallestPrimeFraction {

    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Double.compare((double) arr[a[0]] / arr[a[1]], (double) arr[b[0]] / arr[b[1]]));
        int n = arr.length;
        for (int i = 0; i < Math.min(n, k); i++) {
            minHeap.add(new int[]{i, n - 1});
        }
        int[] entry = null;
        int index = 0;
        while (true) {
            entry = minHeap.poll();
            index++;
            if (index == k) {
                break;
            }
            if (entry[1] - 1 > entry[0]) {
                minHeap.add(new int[]{entry[0], entry[1] - 1});
            }
        }
        return new int[]{arr[entry[0]], arr[entry[1]]};
    }


}
