package trees;


/**
 * @see <a href="https://leetcode.com/problems/binary-tree-cameras/description/">Binary Tree Cameras</a>
 */
public class BinaryTreeCameras {

    int cameraCount = 0;


    public enum State {
        NEEDS_COVER,
        COVERED,
        HAS_CAMERA
    }

    public int minCameraCover(TreeNode root) {

        BinaryTreeCameras.State s = dfs(root);

        if (s == State.NEEDS_COVER) {
            cameraCount++;
        }

        return cameraCount;

    }

    private BinaryTreeCameras.State dfs(TreeNode root) {
        if (root == null) {
            return BinaryTreeCameras.State.COVERED;
        }

        State left = dfs(root.left);
        State right = dfs(root.right);


        if (left == BinaryTreeCameras.State.NEEDS_COVER || right == BinaryTreeCameras.State.NEEDS_COVER) {
            cameraCount++;
            return BinaryTreeCameras.State.HAS_CAMERA;
        }

        if (left == BinaryTreeCameras.State.HAS_CAMERA || right == BinaryTreeCameras.State.HAS_CAMERA) {
            return BinaryTreeCameras.State.COVERED;
        }

        return BinaryTreeCameras.State.NEEDS_COVER;

    }


}




