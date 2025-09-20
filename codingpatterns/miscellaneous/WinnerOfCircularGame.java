package miscellaneous;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @see <a href="https://leetcode.com/problems/find-the-winner-of-the-circular-game/description/">Find the Winner of the Circular Game</a>
 */
public class WinnerOfCircularGame {

    public int findTheWinner(int n, int k) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        Iterator<Integer> ite = list.iterator();
        for (int i = 1; i < n; i++) {
            int numPos = k;
            int j = 0;
            int eleRemoved = -1;
            System.out.println("Num of pos:" + numPos);
            while (j < numPos) {
                if (ite == null || !ite.hasNext()) {
                    ite = list.iterator();
                }
                eleRemoved = ite.next();
                j++;
            }
            System.out.println("Element removed:" + eleRemoved);
            ite.remove();
        }
        return list.peek();
    }

    public int findTheWinnerOptimized(int n, int k) {
        // f(n,k) = (f(n-1,k)+k) mod n; with base case f(1,k) = 0 for 0-based indexing
        int winner = 0;
        for (int i = 2; i <= n; i++) {
            winner = (winner + k) % i;
        }
        return winner + 1; // To match the index with the position starting with 1
    }


}
