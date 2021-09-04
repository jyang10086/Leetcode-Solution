import java.util.HashMap;
import java.util.Map;

class LC105 {

  Map<Integer, Integer> inorderMap;

  public TreeNode buildTree(int[] preorder, int[] inorder) {
    /***
     pre: root left right
     inorder: left root right
     Optimize : use hashmap save root index
     */
    inorderMap = new HashMap<>();
    for (int i = 0; i < inorder.length; i++) {
      inorderMap.put(inorder[i], i);
    }
    return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
  }

  private TreeNode buildTree(int[] preorder, int pl, int pr, int[] inorder, int il, int ir) {
    if (pl > pr || il > ir) return null;
    TreeNode root = new TreeNode(preorder[pl]);
    // find root idx in inorder
    // int idx = il;
    // while(idx < inorder.length) {
    //   if (inorder[idx] == preorder[pl]) {
    //     break;
    //   }
    //   idx++;
    // }
    int idx = inorderMap.get(preorder[pl]);
    int leftCnt = idx - il;
    root.left = buildTree(preorder, pl + 1, pl + leftCnt, inorder, il, idx - 1);
    root.right = buildTree(preorder, pl + leftCnt + 1, pr, inorder, idx + 1, ir);
    return root;
  }
}