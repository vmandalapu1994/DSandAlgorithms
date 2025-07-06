package trees;

import java.util.HashMap;
import java.util.Map;

/**
 * @see <a href="https://leetcode.com/problems/diameter-of-binary-tree/description/">Diameter of Binary Tree</a>
 */

public class DiameterOfBinaryTree {

    private Map<TreeNode, Integer> ht = new HashMap<>();

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int diameter = height(root.left) + height(root.right);

        return Math.max(diameter, Math.max(diameterOfBinaryTree(root.left), diameterOfBinaryTree(root.right)));
    }

    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (ht.containsKey(root)) {
            return ht.get(root);
        }

        if (root.left == null && root.right == null) {
            ht.put(root, 1);
            return 1;
        }

        int height = 1 + Math.max(height(root.left), height(root.right));
        ht.put(root, height);
        return height;
    }

}
