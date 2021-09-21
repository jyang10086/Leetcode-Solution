class LC236 {
  public TreeNode lowestCommonAncestor(TreeNode cur, TreeNode p, TreeNode q) {
    if (cur == null || cur.val == p.val || cur.val == q.val) {
      return cur;
    }
    TreeNode left = lowestCommonAncestor(cur.left, p, q);
    TreeNode right = lowestCommonAncestor(cur.right, p, q);
    if (left != null && right != null) {
      return cur;
    } else if (left != null) {
      return left;
    } else if (right != null) {
      return right;
    }
    return null;
  }
}