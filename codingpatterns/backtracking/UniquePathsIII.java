package backtracking;

public class UniquePathsIII {

    private int count = 0;

    public int uniquePathsIII(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int startX = 0, startY = 0;
        int totalSteps = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    startX = i;
                    startY = j;
                }
                if (grid[i][j] != -1) {
                    totalSteps++;
                }
            }
        }
        solve(grid, visited, startX, startY, 0, totalSteps);
        return count;
    }

    private void solve(int[][] grid, boolean[][] visited, int row, int col, int visitedSteps, int totalSteps) {
        int m = grid.length;
        int n = grid[0].length;
        visitedSteps++;
        if (grid[row][col] == 2) {
            if (visitedSteps == totalSteps) {
                count++;
            }
            return;
        }
        visited[row][col] = true;
        if (row + 1 < m && grid[row + 1][col] != -1 && !visited[row + 1][col]) {
            solve(grid, visited, row + 1, col, visitedSteps, totalSteps);
        }
        if (row - 1 >= 0 && grid[row - 1][col] != -1 && !visited[row - 1][col]) {
            solve(grid, visited, row - 1, col, visitedSteps, totalSteps);
        }
        if (col + 1 < n && grid[row][col + 1] != -1 && !visited[row][col + 1]) {
            solve(grid, visited, row, col + 1, visitedSteps, totalSteps);
        }
        if (col - 1 >= 0 && grid[row][col - 1] != -1 && !visited[row][col - 1]) {
            solve(grid, visited, row, col - 1, visitedSteps, totalSteps);
        }
        visited[row][col] = false;
    }
}
