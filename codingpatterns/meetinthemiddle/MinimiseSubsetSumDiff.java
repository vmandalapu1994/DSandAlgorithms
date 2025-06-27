package meetinthemiddle;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @see <a href="https://leetcode.com/problems/partition-array-into-two-arrays-to-minimize-sum-difference/">
 * Partition Array Into Two Arrays to Minimize Sum Difference</a>
 */
public class MinimiseSubsetSumDiff {

    public int minimumDifference(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int n = nums.length / 2;
        int halfSum = sum / 2;
        List<List<Integer>> lsum = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            lsum.add(new ArrayList<>());
        }
        List<List<Integer>> rsum = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            rsum.add(new ArrayList<>());
        }
        subsetSum(nums, 0, n - 1, 0, 0, 0, lsum);
        subsetSum(nums, n, 2 * n - 1, n, 0, 0, rsum);
        for (int i = 0; i <= n; i++) {
            rsum.get(i).sort(Comparator.naturalOrder());
        }
        int closesum;
        int diff = Integer.MAX_VALUE;
        for (int i = 0; i <= n; i++) {
            int j = n - i;
            int[] rightArray = rsum.get(j).stream().mapToInt(Integer::intValue).toArray();
            for (int k = 0; k < lsum.get(i).size(); k++) {
                int leftsum = lsum.get(i).get(k);
                closesum = halfSum - leftsum;
                int rightsum = closest(rightArray, closesum);
                if (diff > Math.abs(sum - (2 * (leftsum + rightsum)))) {
                    diff = Math.abs(sum - (2 * (leftsum + rightsum)));
                }
            }
        }
        return diff;
    }

    void subsetSum(int[] arr, int s, int e, int curr, int count, int sum, List<List<Integer>> ssum) {
        if (curr > e) {
            ssum.get(count).add(sum);
            return;
        }
        // pick current one
        subsetSum(arr, s, e, curr + 1, count + 1, sum + arr[curr], ssum);

        // non-pick current one
        subsetSum(arr, s, e, curr + 1, count, sum, ssum);

    }

    // Find the closest element for k
    private int closest(int[] arr, int k) {
        if (arr.length == 0) {
            return 0;
        }
        if (k < arr[0]) {
            return arr[0];
        }

        if (k > arr[arr.length - 1]) {
            return arr[arr.length - 1];
        }

        int m = 0;

        int s = 0, e = arr.length - 1;

        while (s <= e) {
            m = s + (e - s) / 2;

            if (arr[m] == k) {
                return arr[m];
            }

            if (arr[m] > k) {
                e = m - 1;
            } else {
                s = m + 1;
            }

        }

        if (Math.abs(arr[s] - k) < Math.abs(arr[e] - k)) {
            return arr[s];
        } else {
            return arr[e];
        }
    }
}
