package Tree;

public class LargestBSTSubtree {
    public int largestBSTSubtree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (isBST(root)) {
            return getNodeCnt(root);
        }
        int left = largestBSTSubtree(root.left);
        int right = largestBSTSubtree(root.right);
        return Math.max(left, right);
    }

    private boolean isBST(TreeNode node, int min, int max) {
        if (node == null) {
            return true;
        }
        if (node.val <= min || node.val >= max) {
            return false;
        }
        return isBST(node.left, min, node.val) && isBST(node.right, node.val, max);
    }

    private boolean isBST(TreeNode node) {
        return isBST(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private int getNodeCnt(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + getNodeCnt(node.left) + getNodeCnt(node.right);
    }
}
