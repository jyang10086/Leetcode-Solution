class LC450 {
  public TreeNode deleteNode(TreeNode root, int key) {
    /***
     locate the key node:
     if node is leaf, return null
     if node has only one subtree, replace the node with child node
     if node has left / right , find the next node and replace node
     */
    if (root == null) return null;
    if (key < root.val) {
      root.left = deleteNode(root.left, key);
    } else if (key > root.val) {
      root.right = deleteNode(root.right, key);
    } else {
      if (root.left == null && root.right == null) {
        return null;
      }
      if (root.left == null) {
        return root.right;
      }
      if (root.right == null) {
        return root.left;
      }
      TreeNode nextNode = getNextNode(root);
      deleteNode(root, nextNode.val);
      root.val = nextNode.val;
    }
    return root;
  }

  private TreeNode getNextNode(TreeNode node) {
    if (node == null) return null;
    TreeNode next = node.right;
    while (next.left != null) {
      next = next.left;
    }
    return next;
  }
}