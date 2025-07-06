package trees;

/**
 * @see <a href="https://leetcode.com/problems/binary-tree-maximum-path-sum/">Binary Tree Maximum Path Sum</a>
 */
public class MaximunPathSum {

    // This variable will store the maximum path sum found anywhere in the tree.
    // Initialize to a very small number to handle negative node values.
    int maxPathSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        // Start the post-order traversal from the root.
        findMaxGain(root);
        return maxPathSum;
    }

    /**
     * This recursive function does two things:
     * 1. Updates the global maxPathSum with the max path that includes the current node as the "peak".
     * 2. Returns the maximum gain for a "straight" path starting from the current node downwards.
     */
    private int findMaxGain(TreeNode node) {
        // Base case: a null node contributes 0 to the path sum.
        if (node == null) {
            return 0;
        }

        // Recursively find the max gain from the left and right subtrees.
        // We use Math.max(0, ...) to discard paths with negative sums.
        // A path would rather not extend into a negative-sum subtree.
        int leftGain = Math.max(0, findMaxGain(node.left));
        int rightGain = Math.max(0, findMaxGain(node.right));

        // Calculate the maximum path sum for a path that "splits" or "bends" at the current node.
        // This is a candidate for the overall maximum but cannot be returned to the parent.
        int currentPathValue = node.val + leftGain + rightGain;

        // Update the global maximum if this path is the best one found so far.
        maxPathSum = Math.max(maxPathSum, currentPathValue);

        // For the recursion, return the maximum gain for a "straight" path.
        // The parent can only choose one of the two branches to extend its path.
        return node.val + Math.max(leftGain, rightGain);
    }

}
