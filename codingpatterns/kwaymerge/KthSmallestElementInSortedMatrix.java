package kwaymerge;

import java.util.PriorityQueue;

/**
 * @see <a href="https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/">Kth Smallest Element in a Sorted Matrix</a>
 */
public class KthSmallestElementInSortedMatrix {

    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        for (int i = 0; i < Math.min(n, k); i++) {
            minHeap.add(new int[]{matrix[i][0], i, 0});
        }
        int index = 0;
        int[] entry = null;
        while (true) {
            entry = minHeap.poll();
            int x = entry[1];
            int y = entry[2];
            index++;
            if (index == k) {
                break;
            }
            if (y < n - 1) {
                minHeap.add(new int[]{matrix[x][y + 1], x, y + 1});
            }
        }
        return entry[0];
    }

}
