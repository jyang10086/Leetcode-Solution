class LC230 {
  int result;
  int cnt;
  public int kthSmallest(TreeNode root, int k) {
    cnt = k;
    inorder(root);
    return result;
  }
  private void inorder(TreeNode node) {
    if (node == null) return;
    inorder(node.left);
    cnt--;
    if (cnt == 0) {
      result = node.val;
      return;
    }
    inorder(node.right);
  }
}