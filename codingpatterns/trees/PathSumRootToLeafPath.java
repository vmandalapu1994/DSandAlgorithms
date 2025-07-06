package trees;

import java.util.ArrayList;
import java.util.List;

/**
 * @see <a href="https://leetcode.com/problems/path-sum-ii/">Path Sum II</a>
 */
public class PathSumRootToLeafPath {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return List.of();
        }

        pathSum(root, targetSum, result, new ArrayList<>(), 0);

        return result;

    }

    public void pathSum(TreeNode root, int targetSum, List<List<Integer>> result, List<Integer> currentPath, int currentSum) {
        currentPath.add(root.val);
        currentSum += root.val;

        if (root.left == null && root.right == null) {
            if (currentSum == targetSum) {
                result.add(new ArrayList<>(currentPath));
            }
        }

        if (root.left != null) {
            pathSum(root.left, targetSum, result, currentPath, currentSum);
            currentPath.remove(currentPath.size() - 1);
        }

        if (root.right != null) {
            pathSum(root.right, targetSum, result, currentPath, currentSum);
            currentPath.remove(currentPath.size() - 1);
        }
    }

}
