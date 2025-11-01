package graph;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @see <a href="https://leetcode.com/problems/is-graph-bipartite/">Is Graph Bipartite?</a>
 * Needs revision
 */
public class BipartiteGraph {

    public boolean isBipartite(int[][] graph) {
        int vertices = graph.length;
        int[] colors = new int[vertices];
        Arrays.fill(colors, -1);
        for (int i = 0; i < vertices; i++) {
            if (colors[i] == -1) {
                if (!isBipartiteDFS(i, graph, colors, 0)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isBipartiteDFS(int v, int[][] graph, int[] colors, int color) {
        colors[v] = color;
        for (int adj : graph[v]) {
            if (colors[adj] == -1) {
                if (!isBipartiteDFS(adj, graph, colors, 1 - color)) {
                    return false;
                }
            } else {
                if (colors[adj] == colors[v]) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isBipartiteBFS(int v, int[][] graph, int[] colors, int color) {
        colors[v] = color;
        LinkedList<Integer> queue = new LinkedList<>();
        queue.offer(v);
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int adj : graph[node]) {
                if (colors[adj] == -1) {
                    colors[adj] = 1 - colors[node];
                    queue.offer(adj);
                } else {
                    if (colors[adj] == colors[node]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
