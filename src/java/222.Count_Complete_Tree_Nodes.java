class LC222 {
  /*
  *
  *
  *  222. Count Complete Tree Nodes
    Given the root of a complete binary tree, return the number of the nodes in the tree.
  *
  *  满二叉树： 2^n - 1
      非满： 1 + count(root.left) + count(root.right)
      O(logn^2): 100万节点--20万次
  * */
  public int countNodes(TreeNode root) {
    if (root == null) return 0;
    int ld = 0, rd = 0;
    TreeNode l = root, r = root;
    while (l != null) {
      ld++;
      l = l.left;
    }
    while (r != null) {
      rd++;
      r = r.right;
    }
    if (ld == rd) {
      return (1 << ld) - 1;
    }
    return countNodes(root.left) + countNodes(root.right) + 1;
  }
}