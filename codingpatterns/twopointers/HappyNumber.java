package twopointers;

/**
 * @see <a href ="https://leetcode.com/problems/happy-number/description/">Happy Number</a>
 */

/**
 * 1) Set slow pointer to the input number and fast pointer to the sum of squared digits of the input number.
 * 2) Move slow pointer to the next sum of squares of digits (one step).
 * 3) Move fast pointer to the next sum of squares of digits twice (two steps).
 * 4) Repeat the process until fast pointer becomes 1 or both pointers meet (both pointers point to the same value, indicating a detected cycle).
 * 5) If fast pointer equals 1, return TRUE (number is happy); otherwise, return FALSE (cycle detected, number is not happy).
 */

public class HappyNumber {

    public boolean isHappy(int n) {
        int fast = digitsSum(n);
        int slow = n;

        while (true) {
            if (fast == 1 || slow == 1) {
                return true;
            }
            if (fast == slow) {
                return false;
            }

            slow = digitsSum(slow);
            int temp = digitsSum(fast);
            fast = digitsSum(temp);
        }

    }

    private int digitsSum(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n = n / 10;
        }
        return sum;
    }


}
