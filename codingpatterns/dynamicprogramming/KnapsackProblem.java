package dynamicprogramming;

/**
 * @see <a href="https://www.geeksforgeeks.org/problems/0-1-knapsack-problem0945/1">0-1 Knapsack problem</a>
 */

/**
 * 1) Create a 2D table to store the maximum profit for each item and capacity.
 * 2) Initialize the table with 0s for the first row and column to handle base cases.
 * 3) Iterate over the remaining rows and columns of the table, filling them in based on whether the weight of an item is less than or equal to the current capacity.
 * 4) If the weight is less than or equal to the current capacity, use the maximum value that can be obtained by either including or excluding the item. Otherwise, exclude the item and use the previous best value at that capacity.
 * 5) Return the value in the last row and column of the table, which represents the maximum value that can be obtained with the given capacity and items.
 */
public class KnapsackProblem {

    static int knapsack(int W, int val[], int wt[]) {
        int[][] value = new int[W + 1][wt.length];
        for (int i = wt[0]; i <= W; i++) {
            value[i][0] = val[0];
        }
        for (int i = 1; i < wt.length; i++) {
            for (int j = 1; j <= W; j++) {
                if (j >= wt[i]) {
                    value[j][i] = Math.max(value[j][i - 1], val[i] + value[j - wt[i]][i - 1]);
                } else {
                    value[j][i] = value[j][i - 1];
                }
            }
        }

        return value[W][wt.length - 1];
    }

    static int knapsackSpaceOptimised(int W, int val[], int wt[]) {
        int[] dp = new int[W + 1];

        for (int i = wt[0]; i <= W; i++) {
            dp[i] = val[0];
        }

        int[] temp = new int[W + 1];
        for (int i = 1; i < wt.length; i++) {

            for (int j = 1; j <= W; j++) {
                if (j >= wt[i]) {
                    temp[j] = Math.max(dp[j], val[i] + dp[j - wt[i]]);
                } else {
                    temp[j] = dp[j];
                }
            }
            dp = temp.clone();
        }

        return dp[W];

    }

    /**
     * We avoided the need for 2nd array from previous solution by traversing inn reverse
     * so that the values are not overwritten which needed later on.
     */
    static int knapsackOptimal(int W, int val[], int wt[]) {
        int[] dp = new int[W + 1];

        for (int i = wt[0]; i <= W; i++) {
            dp[i] = val[0];
        }

        for (int i = 1; i < wt.length; i++) {
            int[] temp = new int[W + 1];
            for (int j = W; j >= wt[i]; j--) {
                dp[j] = Math.max(dp[j], val[i] + dp[j - wt[i]]);
            }
        }

        return dp[W];
    }

}
