package trees;

import java.util.HashMap;
import java.util.Map;

/**
 * @see <a href="https://leetcode.com/problems/path-sum-iii/description/">Path Sum III</a>
 */

// Brute-force solution using preorder traversal and checking path for each node traversed.
public class PathSum3 {
    int count = 0;

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        preOrderTraversal(root, targetSum);
        return count;
    }

    // Traverse through each node and call pathSum func to find paths starting from that node.
    public void preOrderTraversal(TreeNode root, int targetSum) {
        pathSum(root, targetSum, 0);
        if (root.left != null) {
            preOrderTraversal(root.left, targetSum);
        }

        if (root.right != null) {
            preOrderTraversal(root.right, targetSum);
        }

    }

    // Finds paths starting with root and having targetSum
    public void pathSum(TreeNode root, int targetSum, long currentSum) {
        currentSum += root.val;

        if (currentSum == targetSum) {
            count++;
        }

        if (root.left != null) {
            pathSum(root.left, targetSum, currentSum);
        }

        if (root.right != null) {
            pathSum(root.right, targetSum, currentSum);
        }
    }

}

class PathSumUsingPrefixSum {
    int count = 0;
    int target;
    Map<Long, Integer> prefixSumCount;

    public int pathSum(TreeNode root, int targetSum) {
        this.target = targetSum;
        this.prefixSumCount = new HashMap<>();

        // Base case for paths starting from the root.
        // A prefix sum of 0 has been seen one time (before we start).
        prefixSumCount.put(0L, 1);

        dfs(root, 0L);

        return count;
    }

    private void dfs(TreeNode node, long currentPathSum) {
        if (node == null) {
            return;
        }

        // 1. Update the current path sum
        currentPathSum += node.val;

        // 2. Check if there is a prefix sum that we can remove to get the targetSum
        // currentPathSum - prefixSum = target  =>  prefixSum = currentPathSum - target
        count += prefixSumCount.getOrDefault(currentPathSum - target, 0);

        // 3. Add the current path sum to the map for descendant nodes
        prefixSumCount.put(currentPathSum, prefixSumCount.getOrDefault(currentPathSum, 0) + 1);

        // 4. Recurse to children
        dfs(node.left, currentPathSum);
        dfs(node.right, currentPathSum);

        // 5. Backtrack: Remove the current path sum from the map
        // This is crucial so it doesn't affect sibling paths.
        prefixSumCount.put(currentPathSum, prefixSumCount.get(currentPathSum) - 1);
    }
}


