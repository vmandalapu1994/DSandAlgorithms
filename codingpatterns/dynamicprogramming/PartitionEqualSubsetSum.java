package dynamicprogramming;


/**
 * @see <a href="https://leetcode.com/problems/partition-equal-subset-sum/description/">Partition Equal Subset Sum</>
 */

/**
 * 1) Create a matrix of appropriate size and initialize all cells with FALSE.
 * 2) Place TRUE in the first row of the matrix.
 * 3) Traverse the input array, element by element.
 * 4) Fill the cells of matrix either TRUE or FALSE depending upon their inclusion in the subset sum.
 * 5) The value present at the last row and last column indicates whether the array can be partitioned.
 */


public class PartitionEqualSubsetSum {

    public static boolean canPartitionArray(int[] arr) {
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }

        if (sum % 2 != 0) {
            return false;
        }

        boolean[][] subset = new boolean[sum / 2 + 1][arr.length + 1];

        for (int i = 0; i <= arr.length; i++) {
            subset[0][i] = true;
        }

        for (int i = 1; i <= sum / 2; i++) {
            for (int j = 1; j <= arr.length; j++) {
                if (i >= arr[j - 1]) {
                    subset[i][j] = subset[i][j - 1] || subset[i - arr[j - 1]][j - 1];
                } else {
                    subset[i][j] = subset[i][j - 1];
                }
            }
        }

        return subset[sum / 2][arr.length];
    }

    public boolean canPartitionSpaceOptimised(int[] arr) {
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }

        if (sum % 2 != 0) {
            return false;
        }

        boolean[] subset = new boolean[sum / 2 + 1];

        subset[0] = true;


        for (int i = 0; i < arr.length; i++) {
            for (int j = sum / 2; j >= arr[i]; j--) {
                subset[j] = subset[j] || subset[j - arr[i]];
            }
        }


        return subset[sum / 2];


    }


}
