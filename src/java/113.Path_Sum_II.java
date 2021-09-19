class LC113 {
  List<List<Integer>> res;

  public List<List<Integer>> pathSum(TreeNode root, int sum) {
    res = new ArrayList<>();
    dfs(root, sum, new ArrayList<>());
    return res;
  }

  private void dfs(TreeNode node, int sum, List<Integer> path) {
    if (node == null) return;
    if (node.val == sum && node.left == null && node.right == null) {
      path.add(node.val);
      res.add(new ArrayList(path));
      path.remove(path.size() - 1);
      return;
    }
    path.add(node.val);
    dfs(node.left, sum - node.val, path);
    dfs(node.right, sum - node.val, path);
    path.remove(path.size() - 1);
  }
}