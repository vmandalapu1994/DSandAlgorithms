package Heaps;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @see <a href="https://leetcode.com/problems/largest-number-after-digit-swaps-by-parity/">Largest Number After Digit Swaps by Parity</a>
 */
public class LargeNumberAfterSwaps {


    public int largestInteger(int num) {

        PriorityQueue<Integer> even = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> odd = new PriorityQueue<>(Comparator.reverseOrder());

        int n = num;

        List<Boolean> evenFlags = new ArrayList<>();

        while (n > 0) {
            int digit = n % 10;
            if (digit % 2 == 0) {
                even.add(digit);
                evenFlags.add(true);
            } else {
                odd.add(digit);
                evenFlags.add(false);
            }
            n /= 10;
        }

        int largeNum = 0;

        for (int i = evenFlags.size() - 1; i >= 0; i--) {
            if (evenFlags.get(i)) {
                largeNum = largeNum * 10 + even.poll();
            } else {
                largeNum = largeNum * 10 + odd.poll();
            }
        }

        return largeNum;
    }


}
