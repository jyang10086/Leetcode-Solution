class LC129 {
  private int sum;
  public int sumNumbers(TreeNode root) {
    sum = 0;
    getAllPaths(root, 0);
    return sum;
  }

  private void getAllPaths(TreeNode node, int val) {
    if (node == null) return;
    int tmp = val * 10 + node.val;
    if (node.left == null && node.right == null) {
      sum += tmp;
      return;
    }
    getAllPaths(node.left, tmp);
    getAllPaths(node.right, tmp);
  }
}