package monotonicstack;

import java.util.Stack;

/**
 * @see <a href="https://leetcode.com/problems/132-pattern/">132 Pattern</>
 */
public class Pattern132 {

    public boolean find132pattern(int[] nums) {
        if (nums.length < 3) {
            return false;
        }
        //Monotonic decreasing Stack contains candidates for i & j
        Stack<int[]> stack = new Stack<>();
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            while (!stack.isEmpty() && stack.peek()[0] <= nums[i]) {
                stack.pop();
            }
            if (!stack.isEmpty() && stack.peek()[1] < nums[i]) {
                return true;
            }
            stack.push(new int[]{nums[i], min});
            min = Math.min(min, nums[i]);
        }
        return false;
    }

}
