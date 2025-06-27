package dynamicprogramming;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @see <a href="https://leetcode.com/problems/n-th-tribonacci-number/">N-th Tribonacci Number</a>
 */

public class TribonacciNumber {

    public int tribonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }

        Deque<Integer> queue = new ArrayDeque<>();
        queue.add(0);
        queue.add(1);
        queue.add(1);

        for (int i = 3; i <= n; i++) {
            int sum = 0;
            for (Integer j : queue) {
                sum += j;
            }
            queue.pollFirst();
            queue.add(sum);
        }

        return queue.getLast();

    }

}
