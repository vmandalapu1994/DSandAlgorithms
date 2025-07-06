package trees;

/**
 * @see <a href="https://leetcode.com/problems/validate-binary-search-tree/">Validate Binary Search Tree</a>
 */
public class BinarySearchTreeValidation {

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    boolean isValidBST(TreeNode root, long left, long right) {
        if (root == null) {
            return true;
        }
        if (root.val <= left || root.val >= right) {
            return false;
        }
        return isValidBST(root.left, left, root.val) && isValidBST(root.right, root.val, right);
    }

}
