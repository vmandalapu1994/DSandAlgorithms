package kwaymerge;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @see <a href="https://leetcode.com/problems/super-ugly-number/">Super Ugly Number</a>
 */
public class SuperUglyNumber {

    public int nthSuperUglyNumber(int n, int[] primes) {
        if (n == 1) {
            return 1;
        }
        List<Integer> ugly = new ArrayList<>();
        ugly.add(1);
        PriorityQueue<long[]> minHeap = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));
        for (int prime : primes) {
            minHeap.add(new long[]{prime, prime, 0});
        }
        while (true) {
            long[] entry = minHeap.poll();
            long prime = entry[1];
            long index = entry[2];
            if (ugly.get(ugly.size() - 1) != entry[0]) {
                ugly.add((int) entry[0]);
            }
            if (ugly.size() == n) {
                break;
            }
            minHeap.add(new long[]{entry[1] * ugly.get((int) index + 1), prime, index + 1});
        }
        return ugly.get(ugly.size() - 1);
    }
}
