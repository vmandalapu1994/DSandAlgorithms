package graph;

import java.util.LinkedList;

/**
 * @see <a href="https://leetcode.com/problems/longest-increasing-path-in-a-matrix/">Longest Increasing Path in a Matrix</a>
 */
public class LongestIncreasingPathInAMatrix {

    private int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int longestIncreasingPathUsingDFS(int[][] matrix) {
        int longPathLength = 0;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] len = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                longPathLength = Math.max(longPathLength, dfs(row, col, rows, cols, matrix, len));
            }
        }

        return longPathLength;
    }

    /**
     * Using Khan's algorithm for topological sorting.
     *
     * @param matrix Matrix
     * @return Length of longest increasing path.
     */
    public int longestIncreasingPathUsingTopologicalSortBFS(int[][] matrix) {
        int longPathLength = 0;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] inDegrees = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                for (int[] dir : dirs) {
                    int newRow = row + dir[0];
                    int newCol = col + dir[1];
                    if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && matrix[newRow][newCol] > matrix[row][col]) {
                        inDegrees[newRow][newCol]++;
                    }
                }
            }
        }
        LinkedList<int[]> queue = new LinkedList<>();
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (inDegrees[row][col] == 0) {
                    queue.addLast(new int[]{row, col});
                }
            }
        }

        while (!queue.isEmpty()) {
            longPathLength++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] entry = queue.removeFirst();
                int row = entry[0];
                int col = entry[1];
                for (int[] dir : dirs) {
                    int newRow = row + dir[0];
                    int newCol = col + dir[1];
                    if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && matrix[newRow][newCol] > matrix[row][col]) {
                        inDegrees[newRow][newCol]--;
                        if (inDegrees[newRow][newCol] == 0) {
                            queue.add(new int[]{newRow, newCol});
                        }
                    }
                }
            }
        }
        return longPathLength;
    }

    private int dfs(int row, int col, int rows, int cols, int[][] matrix, int[][] len) {
        if (len[row][col] != 0) {
            return len[row][col];
        }
        int maxLength = 1;
        for (int[] dir : dirs) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && matrix[newRow][newCol] > matrix[row][col]) {
                maxLength = Math.max(maxLength, 1 + dfs(newRow, newCol, rows, cols, matrix, len));
            }
        }
        len[row][col] = maxLength;
        return maxLength;
    }
}
