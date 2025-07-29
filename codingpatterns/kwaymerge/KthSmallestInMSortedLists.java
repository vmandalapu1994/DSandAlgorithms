package kwaymerge;

import java.util.List;
import java.util.PriorityQueue;

/**
 * Given `m` sorted lists in ascending order and an integer `k`, find the `kth` smallest element among all the lists.
 * <p>
 * Even if some values appear multiple times across the lists, each occurrence is treated as a unique element when determining the `kth` smallest number.
 * <p>
 * If `k` exceeds the total number of elements across all lists, return the largest element among them. If the lists are empty, return `0`.
 * <p>
 * ### Constraints:
 * * `1 <= m <= 50`
 * * `0 <= list[i].length <= 50`
 * * `-10^9 <= list[i][j] <= 10^9`
 * * `1 <= k <= 10^9`
 */

public class KthSmallestInMSortedLists {

    public static int kSmallestNumber(List<List<Integer>> lists, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
        for (int i = 0; i < lists.size(); i++) {
            if (!lists.get(i).isEmpty()) {
                queue.add(new int[]{i, 0, lists.get(i).get(0)});
            }
        }
        int index = 0;
        int kthNumber = 0;
        int[] arr = null;
        while (!queue.isEmpty()) {
            arr = queue.poll();
            index++;
            if (index == k) {
                kthNumber = arr[2];
                break;
            }
            if (lists.get(arr[0]).size() > arr[1] + 1) {
                queue.add(new int[]{arr[0], arr[1] + 1, lists.get(arr[0]).get(arr[1] + 1)});
            }
        }
        if (kthNumber == 0 && arr != null) {
            kthNumber = arr[2];
        }
        return kthNumber;
    }
}
