package dynamicprogramming;

/**
 * @see <a href="https://leetcode.com/problems/minimum-path-sum/description/">Minimum Path Sum</a>
 */
public class MinimumPathSum {

    public int minPathSum(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] minSum = new int[rows][cols];
        for (int row = rows - 1; row >= 0; row--) {
            for (int col = cols - 1; col >= 0; col--) {
                int sum = grid[row][col];
                if (row == rows - 1 && col == cols - 1) {
                    minSum[row][col] = sum;
                    continue;
                }
                int downSum = Integer.MAX_VALUE;
                int rightSum = Integer.MAX_VALUE;
                if (row < rows - 1) {
                    downSum = minSum[row + 1][col];
                }
                if (col < cols - 1) {
                    rightSum = minSum[row][col + 1];
                }
                sum += Math.min(downSum, rightSum);
                minSum[row][col] = sum;
            }
        }
        return minSum[0][0];
    }

}
