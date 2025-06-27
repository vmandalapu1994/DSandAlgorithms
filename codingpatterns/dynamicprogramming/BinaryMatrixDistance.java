package dynamicprogramming;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @see <a href="https://leetcode.com/problems/01-matrix/description/">01 Matrix</a>
 */
public class BinaryMatrixDistance {

    // Below solution is using multi-source BFS approach
    public int[][] updateMatrixBFSWithVisitFlag(int[][] mat) {
        LinkedList<Integer> l = new LinkedList<>();
        int m = mat.length;
        int n = mat[0].length;
        boolean[][] v = new boolean[m][n];
        int[][] dist = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    l.add(i * 10000 + j);
                    dist[i][j] = 0;
                }
            }
        }

        while (!l.isEmpty()) {
            int val = l.pollFirst();
            int i = val / 10000;
            int j = val % 10000;
            if (i + 1 < m && !v[i + 1][j] && dist[i + 1][j] > dist[i][j] + 1) {
                dist[i + 1][j] = dist[i][j] + 1;
                l.add((i + 1) * 10000 + j);
            }
            if (i - 1 >= 0 && !v[i - 1][j] && dist[i - 1][j] > dist[i][j] + 1) {
                dist[i - 1][j] = dist[i][j] + 1;
                l.add((i - 1) * 10000 + j);
            }
            if (j + 1 < n && !v[i][j + 1] && dist[i][j + 1] > dist[i][j] + 1) {
                dist[i][j + 1] = dist[i][j] + 1;
                l.add(i * 10000 + (j + 1));
            }
            if (j - 1 >= 0 && !v[i][j - 1] && dist[i][j - 1] > dist[i][j] + 1) {
                dist[i][j - 1] = dist[i][j] + 1;
                l.add(i * 10000 + (j - 1));
            }
            v[i][j] = true;
        }

        return dist;
    }

    public int[][] updateMatrixBFSWithOutVisitFlag(int[][] mat) {
        LinkedList<Integer> l = new LinkedList<>();
        int m = mat.length;
        int n = mat[0].length;
        int[][] dist = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    l.add(i * 10000 + j);
                    dist[i][j] = 0;
                }
            }
        }

        while (!l.isEmpty()) {
            int val = l.pollFirst();
            int i = val / 10000;
            int j = val % 10000;
            if (i + 1 < m && dist[i + 1][j] == Integer.MAX_VALUE && dist[i + 1][j] > dist[i][j] + 1) {
                dist[i + 1][j] = dist[i][j] + 1;
                l.add((i + 1) * 10000 + j);
            }
            if (i - 1 >= 0 && dist[i - 1][j] == Integer.MAX_VALUE && dist[i - 1][j] > dist[i][j] + 1) {
                dist[i - 1][j] = dist[i][j] + 1;
                l.add((i - 1) * 10000 + j);
            }
            if (j + 1 < n && dist[i][j + 1] == Integer.MAX_VALUE && dist[i][j + 1] > dist[i][j] + 1) {
                dist[i][j + 1] = dist[i][j] + 1;
                l.add(i * 10000 + (j + 1));
            }
            if (j - 1 >= 0 && dist[i][j - 1] == Integer.MAX_VALUE && dist[i][j - 1] > dist[i][j] + 1) {
                dist[i][j - 1] = dist[i][j] + 1;
                l.add(i * 10000 + (j - 1));
            }
        }

        return dist;
    }


    public int[][] updateMatrixBFSSpaceOptimised(int[][] mat) {
        LinkedList<Integer> l = new LinkedList<>();
        int m = mat.length;
        int n = mat[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    l.add(i * 10000 + j);
                } else {
                    mat[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        while (!l.isEmpty()) {
            int val = l.pollFirst();
            int i = val / 10000;
            int j = val % 10000;
            if (i + 1 < m && mat[i + 1][j] == Integer.MAX_VALUE && mat[i + 1][j] > mat[i][j] + 1) {
                mat[i + 1][j] = mat[i][j] + 1;
                l.add((i + 1) * 10000 + j);
            }
            if (i - 1 >= 0 && mat[i - 1][j] == Integer.MAX_VALUE && mat[i - 1][j] > mat[i][j] + 1) {
                mat[i - 1][j] = mat[i][j] + 1;
                l.add((i - 1) * 10000 + j);
            }
            if (j + 1 < n && mat[i][j + 1] == Integer.MAX_VALUE && mat[i][j + 1] > mat[i][j] + 1) {
                mat[i][j + 1] = mat[i][j] + 1;
                l.add(i * 10000 + (j + 1));
            }
            if (j - 1 >= 0 && mat[i][j - 1] == Integer.MAX_VALUE && mat[i][j - 1] > mat[i][j] + 1) {
                mat[i][j - 1] = mat[i][j] + 1;
                l.add(i * 10000 + (j - 1));
            }
        }

        return mat;
    }


    // Solution using 2 pass DP solution to break circular dependency
    public int[][] updateMatrixDP(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int large_num = m * n;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    continue;
                }
                mat[i][j] = Math.min(i - 1 >= 0 ? mat[i - 1][j] : large_num, j - 1 >= 0 ? mat[i][j - 1] : large_num) + 1;
            }
        }

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (mat[i][j] == 0) {
                    continue;
                }
                int min_value_2 = 1 + Math.min(j + 1 < n ? mat[i][j + 1] : large_num, i + 1 < m ? mat[i + 1][j] : large_num);
                mat[i][j] = Math.min(mat[i][j], min_value_2);
            }
        }


        return mat;
    }

}
