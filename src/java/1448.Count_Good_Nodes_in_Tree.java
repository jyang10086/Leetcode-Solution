class LC1448 {
  public int goodNodes(TreeNode root) {
    if (root == null) return 0;
    return dfs(root.left, root.val) + dfs(root.right, root.val) + 1;
  }
  private int dfs(TreeNode node, int curMax) {
    if (node == null) return 0;
    if (node.val >= curMax) {
      curMax = node.val;
      return 1 + dfs(node.left, curMax) + dfs(node.right, curMax);
    }
    return dfs(node.left, curMax) + dfs(node.right, curMax);
  }
}