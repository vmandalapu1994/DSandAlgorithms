package unionfind;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @see <a href="https://leetcode.com/problems/number-of-provinces/description/">Number of Provinces</a>
 */
public class NumberOfProvinces {

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isConnected[i][j] == 1) {
                    uf.union(i, j);
                }
            }
        }
        return uf.findDistinctGroups();
    }
}

class UnionFind {

    private int[] parent;
    private int[] rank;

    UnionFind(int n) {
        parent = new int[n];
        rank = new int[n];
        Arrays.fill(parent, -1);
        Arrays.fill(rank, 0);
    }

    void union(int n1, int n2) {
        int p1 = find(n1);
        int p2 = find(n2);
        if (p1 == p2) {
            return;
        }
        if (rank[p1] < rank[p2]) {
            parent[p1] = p2;
        } else {
            parent[p2] = p1;
            rank[p1]++;
        }
    }

    int find(int n1) {
        if (parent[n1] == -1) {
            return n1;
        }
        parent[n1] = find(parent[n1]);
        return parent[n1];
    }

    int findDistinctGroups() {
        Set<Integer> groups = new HashSet<>();
        for (int i = 0; i < parent.length; i++) {
            groups.add(find(i));
        }
        return groups.size();
    }
}
