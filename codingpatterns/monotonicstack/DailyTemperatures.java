package monotonicstack;

import java.util.Stack;

/**
 * @see <a href="https://leetcode.com/problems/daily-temperatures/">Daily Temperatures</a>
 */
public class DailyTemperatures {

    public int[] dailyTemperatures(int[] temperatures) {
        int size = temperatures.length;
        int[] result = new int[size];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < size; i++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                int index = stack.pop();
                result[index] = i - index;
            }
            stack.push(i);
        }
        return result;
    }
}
