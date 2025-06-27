package dynamicprogramming;

/**
 * @see <a href="https://leetcode.com/problems/last-stone-weight-ii/description/">Last Stone Weight II</a>
 * This problem is a variation of Partition Equal Subset Sum.
 */
public class LastStoneWeight {

    public int lastStoneWeightII(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        int sum = 0;

        for (int num : nums) {
            sum += num;
        }

        int halfSum = sum / 2;

        boolean[] arr = new boolean[halfSum + 1];
        arr[0] = true;

        int diff = Integer.MAX_VALUE;

        for (int i = 1; i <= nums.length; i++) {
            for (int j = halfSum; j >= nums[i - 1]; j--) {

                arr[j] = arr[j] || arr[j - nums[i - 1]];

                if (arr[j]) {
                    if (diff > Math.abs(sum - 2 * j)) {
                        diff = Math.abs(sum - 2 * j);
                    }
                }

            }
        }

        return diff;

    }
}
