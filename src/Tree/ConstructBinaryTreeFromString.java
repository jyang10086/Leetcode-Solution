package Tree;

public class ConstructBinaryTreeFromString {
    private int idx;

    public TreeNode str2tree(String s) {
        return buildTree(s);
    }

    private TreeNode buildTree(String str) {
        int len = str.length();
        StringBuilder num = new StringBuilder();
        while (idx < len && (str.charAt(idx) == '-' || Character.isDigit(str.charAt(idx)))) {
            num.append(str.charAt(idx));
            idx++;
        }
        if (num.length() == 0) {
            return null;
        }
        System.out.println(num.toString());
        TreeNode node = new TreeNode(Integer.parseInt(num.toString()));

        if (idx < len && str.charAt(idx) == '(') {
            ++idx;
            node.left = buildTree(str);
            if (idx < len && str.charAt(idx) == '(') {
                ++idx;
                node.right = buildTree(str);
            }
        }
        ++idx;
        return node;
    }
}
