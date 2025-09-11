package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @see <a href="https://leetcode.com/problems/network-delay-time/description/">Network Delay Time</a>
 */

public class NetworkDelayTime {

    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> adjacencyList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        for (int[] edge : times) {
            adjacencyList.get(edge[0] - 1).add(new int[]{edge[1] - 1, edge[2]});
        }
        int maxDist = Integer.MIN_VALUE;
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        queue.add(new int[]{k - 1, 0});
        dist[k - 1] = 0;
        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int currNode = node[0];
            int currDist = node[1];
            // // Skip stale entries
            if (currDist > dist[currNode]) {
                continue;
            }
            List<int[]> neighbours = adjacencyList.get(currNode);
            for (int[] nnode : neighbours) {
                int nextNode = nnode[0];
                int weight = nnode[1];
                // Only add entries to PQ if the new distance is shorter
                if (dist[nextNode] > (currDist + weight)) {
                    dist[nextNode] = currDist + weight;
                    queue.add(new int[]{nextNode, dist[nextNode]});
                }
            }
        }
        for (int d : dist) {
            // Means not all nodes are reachable
            if (d == Integer.MAX_VALUE) {
                return -1;
            }
            if (maxDist < d) {
                maxDist = d;
            }
        }
        return maxDist;
    }
}
