package graph;

import java.util.*;

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
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        queue.add(new int[]{k - 1, 0});
        Set<Integer> visited = new HashSet<>();
        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int currNode = node[0];
            int currDist = node[1];
            if (visited.contains(currNode)) {
                continue;
            }
            visited.add(currNode);
            maxDist = Math.max(maxDist, currDist);
            List<int[]> neighbours = adjacencyList.get(currNode);
            for (int[] neighbour : neighbours) {
                int nextNode = neighbour[0];
                int weight = neighbour[1];
                if (!visited.contains(nextNode)) {
                    queue.add(new int[]{nextNode, currDist + weight});
                }
            }
        }
        return visited.size() == n ? maxDist : -1;
    }
}
