package dynamicprogramming;

/**
 * @see <a href="https://leetcode.com/problems/house-robber-ii/">House Robber II</a>
 */

/**
 * Divide the houses into two sets. The first set does not include the last house, and the second set does not include the first house.
 * <p>
 * Compute the maximum possible robbery amount in each set, starting from the leftmost house.
 * <p>
 * Store the maximum possible robbery amount against each house, and use it in the computations for the next houses.
 * <p>
 * At each house: maximum amount robbed = max(money in current house + max amount robbed up to the house before last, max robbery up to the last house)
 * <p>
 * Return the maximum amount robbed after traversing all the houses in the set.
 * <p>
 * Compute the maximum possible amount robbed from both sets, and return the greater of the two amounts.
 */

public class HouseRobber2 {

    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        return Math.max(maxRobAmt(nums, 0, nums.length - 2), maxRobAmt(nums, 1, nums.length - 1));
    }


    public int maxRobAmt(int[] nums, int start, int end) {
        int[] rob = new int[nums.length];

        rob[start] = nums[start];
        for (int i = start + 1; i <= end; i++) {
            rob[i] = Math.max(rob[i - 1], i - 2 >= start ? rob[i - 2] + nums[i] : nums[i]);
        }

        return rob[end];
    }

}
