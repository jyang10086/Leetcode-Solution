import java.util.*;

class LC863 {
  /**
   * Given the root of a binary tree, the value of a target node target, and an integer k,
   * return an array of the values of all nodes that have a distance k from the target node.
   * <p>
   * You can return the answer in any order.
   * <p>
   * Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, k = 2
   * Output: [7,4,1]
   * Explanation: The nodes that are a distance 2 from the target node (with value 5) have values 7, 4, and 1.
   */
  public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
    /**
     * 1. build <node, parent> map
     * 2. traverse from target node to parent / children
     * */
    if (k == 0) return Arrays.asList(target.val);
    Map<TreeNode, TreeNode> parent = new HashMap<>();
    buildParentMap(root, null, parent);
    List<Integer> res = new ArrayList<>();
    Set<TreeNode> visited = new HashSet();
    getKDistanceNodes(target, k, parent, res, visited);
    return res;
  }

  private void buildParentMap(TreeNode node, TreeNode parent, Map<TreeNode, TreeNode> parents) {
    if (node == null) return;
    if (!parents.containsKey(node)) {
      parents.put(node, parent);
      buildParentMap(node.left, node, parents);
      buildParentMap(node.right, node, parents);
    }
  }

  private void getKDistanceNodes(TreeNode node, int dis, Map<TreeNode, TreeNode> parents, List<Integer> res, Set<TreeNode> visited) {
    if (node == null || visited.contains(node)) {
      return;
    }
    if (dis == 0) {
      res.add(node.val);
      return;
    }
    visited.add(node);
    if (node.left != null) {
      getKDistanceNodes(node.left, dis - 1, parents, res, visited);
    }
    if (node.right != null) {
      getKDistanceNodes(node.right, dis - 1, parents, res, visited);
    }
    if (parents.get(node) != null) {
      getKDistanceNodes(parents.get(node), dis - 1, parents, res, visited);
    }
  }
}