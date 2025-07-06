package trees;

/**
 * @see <a href="https://leetcode.com/problems/path-sum/">Path Sum</a>
 */

public class PathSumRootToLeaf {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        return hasPathSum(root, targetSum, 0);
    }

    public boolean hasPathSum(TreeNode root, int targetSum, int currentSum) {
        currentSum += root.val;

        // Leaf node
        if (root.left == null && root.right == null) {
            return targetSum == currentSum;
        }

        boolean hasLeftPath = false;

        if (root.left != null) {
            hasLeftPath = hasPathSum(root.left, targetSum, currentSum);
        }

        boolean hasRightPath = false;

        if (root.right != null) {
            hasRightPath = hasPathSum(root.right, targetSum, currentSum);
        }

        return hasLeftPath || hasRightPath;
    }
}
