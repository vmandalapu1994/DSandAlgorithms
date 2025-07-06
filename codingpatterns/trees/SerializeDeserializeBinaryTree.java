package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @see <a href="https://leetcode.com/problems/serialize-and-deserialize-binary-tree/">Serialize and Deserialize Binary Tree</a>
 */

public class SerializeDeserializeBinaryTree {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return null;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        List<String> list = new ArrayList<>();

        while (!queue.isEmpty()) {
            TreeNode n = queue.pollFirst();

            if (n == null) {
                list.add("null");
                continue;
            } else {
                list.add(n.val + "");
            }

            queue.add(n.left);
            queue.add(n.right);
        }

        String[] nodes = list.toArray(new String[0]);
        return String.join(",", nodes);
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.isEmpty()) {
            return null;
        }

        String[] nodes = data.split(",");
        int index = 0;
        LinkedList<TreeNode> queue = new LinkedList<>();

        TreeNode root = new TreeNode(Integer.valueOf(nodes[0]));
        queue.add(root);
        index++;

        while (!queue.isEmpty() && index < nodes.length) {
            TreeNode curr = queue.pollFirst();
            String left = nodes[index];
            if ("null".equals(left)) {
                curr.left = null;
            } else {
                TreeNode leftNode = new TreeNode(Integer.valueOf(left));
                curr.left = leftNode;
                queue.add(leftNode);
            }
            index++;
            String right = nodes[index];
            if ("null".equals(right)) {
                curr.right = null;
            } else {
                TreeNode rightNode = new TreeNode(Integer.valueOf(right));
                curr.right = rightNode;
                queue.add(rightNode);
            }
            index++;
        }

        return root;
    }
}
