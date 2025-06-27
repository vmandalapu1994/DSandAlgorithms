package dynamicprogramming;

/**
 * @see <a href="https://leetcode.com/problems/counting-bits/">Counting Bits</a>
 */
public class CountingBits {

    public int[] countBits(int n) {
        if (n == 0) {
            return new int[]{0};
        }
        if (n == 1) {
            return new int[]{0, 1};
        }
        int[] bits = new int[n + 1];
        bits[0] = 0;
        bits[1] = 1;
        for (int i = 2; i <= n; i++) {
            if (i % 2 == 0) {
                bits[i] = bits[i / 2];
            } else {
                bits[i] = bits[i / 2] + 1;
            }
        }
        return bits;
    }

}
