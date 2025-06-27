package dynamicprogramming;

/**
 * @see <a href="https://leetcode.com/problems/house-robber/description/">House Robber</a>
 */
public class HouseRobber {

    public int rob(int[] nums) {

        int[] rob = new int[nums.length];
        rob[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            rob[i] = Math.max(rob[i - 1], i - 2 >= 0 ? rob[i - 2] + nums[i] : nums[i]);
        }

        return rob[nums.length - 1];
    }

}
