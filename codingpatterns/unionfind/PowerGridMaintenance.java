package unionfind;

import java.util.*;

/**
 * @see <a href="https://leetcode.com/problems/power-grid-maintenance/">Power Grid Maintenance</a>
 */
public class PowerGridMaintenance {

    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        int[] set = new int[c + 1];

        Arrays.fill(set, -1);

        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();

        for (int[] conn : connections) {
            int u = parent(set, conn[0]);
            int v = parent(set, conn[1]);
            if (u != v) {
                set[u] = v;
            }
        }

        for (int i = 1; i <= c; i++) {
            int v = parent(set, i);
            map.putIfAbsent(v, new PriorityQueue<Integer>());
            PriorityQueue<Integer> minHeap = map.get(v);
            minHeap.add(i);
        }

        boolean[] offline = new boolean[c + 1];

        List<Integer> result = new ArrayList<>();

        for (int[] q : queries) {
            if (q[0] == 1) {
                int u = parent(set, q[1]);
                PriorityQueue<Integer> minHeap = map.get(u);
                if (!offline[q[1]]) {
                    result.add(q[1]);
                } else {
                    if (minHeap == null) {
                        result.add(-1);
                    } else {
                        while (!minHeap.isEmpty() && offline[minHeap.peek()]) {
                            minHeap.poll();
                        }
                        result.add(minHeap.isEmpty() ? -1 : minHeap.peek());
                    }
                }

            } else {
                offline[q[1]] = true;
            }
        }

        return result.stream().mapToInt(i -> i).toArray();

    }

    //Path compression
    int parent(int[] set, int u) {
        if (set[u] == -1) {
            return u;
        }
        return set[u] = parent(set, set[u]);
    }
}
