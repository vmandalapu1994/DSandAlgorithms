package trees;

/**
 * @see <a href="https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description/">Lowest Common Ancestor of a Binary Tree</a>
 */
public class LowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Base case: if we've reached the end, or found p or q, return the node itself.
        // This uses reference equality (==), which is correct.
        if (root == null || root == p || root == q) {
            return root;
        }

        // Search in the left and right subtrees.
        TreeNode leftResult = lowestCommonAncestor(root.left, p, q);
        TreeNode rightResult = lowestCommonAncestor(root.right, p, q);

        // If both children returned a node, this root is the LCA.
        if (leftResult != null && rightResult != null) {
            return root;
        }

        // Otherwise, the result is whichever subtree returned a non-null node.
        // This cleanly propagates the result upwards.
        return leftResult != null ? leftResult : rightResult;
    }

}


class LCAStateful {

    TreeNode lca = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        anyNodeFound(root, p, q);
        return lca;
    }

    public boolean anyNodeFound(TreeNode node, TreeNode p, TreeNode q) {

        if (node == null) {
            return false;
        }

        boolean mid = false;

        if (node == p || node == q) {
            mid = true;
        }

        boolean left = anyNodeFound(node.left, p, q);
        boolean right = anyNodeFound(node.right, p, q);

        int count = 0;
        if (mid) {
            count++;
        }
        if (left) {
            count++;
        }
        if (right) {
            count++;
        }

        if (count == 2) {
            lca = node;
        }

        return mid | left | right;
    }

}

