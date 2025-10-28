package graph;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @see <a href="https://leetcode.com/problems/min-cost-to-connect-all-points/">Min Cost to Connect All Points</a>
 *
 * Needs revision.
 */
public class MinCostToConnectAllPoints {

    public int minCostConnectPoints(int[][] points) {
        if (points.length < 2) {
            return 0;
        }
        PriorityQueue<int[]> edges = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        int count = points.length;
        int visitedCount = 1;
        for (int i = 1; i < count; i++) {
            edges.offer(new int[]{0, i, distance(points[0], points[i])});
        }
        int totalCost = 0;
        boolean[] visited = new boolean[count];
        visited[0] = true;
        int[] distanceArr = new int[count];
        Arrays.fill(distanceArr, Integer.MAX_VALUE);
        while (visitedCount < count && !edges.isEmpty()) {
            int[] entry = edges.remove();
            int src = entry[0];
            int dest = entry[1];
            int dist = entry[2];
            if (visited[dest]) {
                continue;
            }
            visited[dest] = true;
            visitedCount++;
            totalCost += dist;
            for (int i = 0; i < count; i++) {
                if (!visited[i]) {
                    int newDist = distance(points[dest], points[i]);
                    if (newDist < distanceArr[i]) {
                        distanceArr[i] = newDist;
                        edges.offer(new int[]{dest, i, newDist});
                    }
                }
            }
        }
        return totalCost;
    }

    private int distance(int[] pt1, int[] pt2) {
        return Math.abs(pt1[0] - pt2[0]) + Math.abs(pt1[1] - pt2[1]);
    }

}
