package dynamicprogramming;

import java.util.List;

/**
 * @see <a href="https://www.geeksforgeeks.org/double-knapsack-dynamic-programming/">Double Knapsack | Dynamic Programming</>
 */

public class DoubleKnapsack {

    public static int doubleKnapsack(int[] wt, int c1, int c2) {
        int[][][] weight = new int[wt.length + 1][c1 + 1][c2 + 1];
        for (int i = 1; i <= wt.length; i++) {
            for (int j = 0; j <= c1; j++) {
                for (int k = 0; k <= c2; k++) {
                    // Current item not included in either of the Knapsacks.
                    weight[i][j][k] = weight[i - 1][j][k];
                    // Include in first knapsack.
                    if (j >= wt[i - 1]) {
                        weight[i][j][k] = Math.max(weight[i - 1][j - wt[i - 1]][k] + wt[i - 1], weight[i][j][k]);
                    }
                    // Include in second knapsack.
                    if (k >= wt[i - 1]) {
                        weight[i][j][k] = Math.max(weight[i - 1][j][k - wt[i - 1]] + wt[i - 1], weight[i][j][k]);
                    }
                }
            }
        }
        return weight[wt.length][c1][c2];
    }

    static int maxWeight(List<Integer> arr, int capacity1,
                         int capacity2) {
        int n = arr.size();

        // Initialize a 3D DP array with dimensions (n+1) x
        // (w1+1) x (w2+1)
        int[][][] dp = new int[n + 1][capacity1 + 1][capacity2 + 1];

        // Fill the DP array iteratively
        for (int i = 1; i <= n; i++) {
            int weight = arr.get(i - 1);
            for (int j = 0; j <= capacity1; j++) {
                for (int k = 0; k <= capacity2; k++) {

                    // Option 1: Don't take the current item
                    dp[i][j][k] = dp[i - 1][j][k];

                    // Option 2: Take the current item in
                    // the first knapsack, if possible
                    if (j >= weight) {
                        dp[i][j][k] = Math.max(
                                dp[i][j][k],
                                weight
                                        + dp[i - 1][j - weight][k]);
                    }

                    // Option 3: Take the current item in
                    // the second knapsack, if possible
                    if (k >= weight) {
                        dp[i][j][k] = Math.max(
                                dp[i][j][k],
                                weight
                                        + dp[i - 1][j][k - weight]);
                    }
                }
            }
        }

        return dp[n][capacity1][capacity2];
    }

    public static void main(String[] args) {
        System.out.println(doubleKnapsack(new int[]{8, 3, 2}, 10, 3));
        System.out.println(doubleKnapsack(new int[]{8, 5, 3}, 10, 3));

        System.out.println(maxWeight(List.of(8, 3, 2), 10, 3));
        System.out.println(maxWeight(List.of(8, 5, 3), 10, 3));
    }

}
