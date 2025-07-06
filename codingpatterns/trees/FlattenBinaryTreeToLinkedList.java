package trees;

/**
 * @see <a href="https://leetcode.com/problems/flatten-binary-tree-to-linked-list/">Flatten Binary Tree to Linked List</a>
 */
public class FlattenBinaryTreeToLinkedList {


    TreeNode prev = null;

    public void flatten(TreeNode root) {
        preOrder(root);
    }

    void preOrder(TreeNode node) {
        if (node == null) {
            return;
        }

        if (prev == null) {
            prev = node;
        } else {
            prev.right = node;
            prev = node;
        }

        TreeNode right = node.right;

        preOrder(node.left);
        node.left = null;
        preOrder(right);
    }


}

/**
 * Reverse preorder traversal.
 */
class ReversePreOrderTraversal {

    TreeNode prev = null;

    public void flatten(TreeNode root) {
        reversePreOrder(root);
    }

    void reversePreOrder(TreeNode node) {
        if (node == null) {
            return;
        }

        reversePreOrder(node.right);
        reversePreOrder(node.left);

        node.left = null;
        node.right = prev;

        prev = node;

    }
}


/**
 * This solution doesn't use any extra space.
 */
class IterativeOptimalSolution {

    public void flatten(TreeNode root) {
        TreeNode current = root;
        while (current != null) {
            // If there is a left subtree
            if (current.left != null) {
                // Find the rightmost node of the left subtree (the predecessor)
                TreeNode predecessor = current.left;
                while (predecessor.right != null) {
                    predecessor = predecessor.right;
                }

                // 1. Link the predecessor to the current node's right child
                predecessor.right = current.right;

                // 2. Move the entire left subtree to the right
                current.right = current.left;

                // 3. Set the left child to null
                current.left = null;
            }

            // Move on to the next node in the flattened list
            current = current.right;
        }
    }
}
