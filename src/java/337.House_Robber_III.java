class LC337 {
  public int rob(TreeNode root) {
    int[] res = tryRob(root);
    return Math.max(res[0],res[1]);
  }

  private int[] tryRob(TreeNode node) {
    if (node == null) return new int[2];
    int[] left = tryRob(node.left);
    int[] right = tryRob(node.right);
    int[] res = new int[2];
    res[0] = Math.max(left[0],left[1]) + Math.max(right[0],right[1]); // not stolen
    res[1] = node.val + left[0] + right[0]; // stolen cur
    return res;
  }
}