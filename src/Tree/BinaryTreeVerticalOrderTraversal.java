package Tree;

import java.util.*;

public class BinaryTreeVerticalOrderTraversal {
    class NewNode {
        int column;
        TreeNode treeNode;

        public NewNode(int b, TreeNode c) {
            column = b;
            treeNode = c;
        }
    }

    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<NewNode> queue = new LinkedList<>();
        Map<Integer, List<Integer>> map = new TreeMap<>(); // <column, list[column]>
        NewNode curNode = new NewNode(0, root);
        queue.offer(curNode);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                NewNode node = queue.poll();
                TreeNode treeNode = node.treeNode;
                int curColumn = node.column;
                if (!map.containsKey(curColumn)) {
                    map.put(curColumn, new ArrayList<>());
                }
                map.get(curColumn).add(treeNode.val);
                if (treeNode.left != null) {
                    queue.offer(new NewNode(curColumn - 1, treeNode.left));
                }
                if (treeNode.right != null) {
                    queue.offer(new NewNode(curColumn + 1, treeNode.right));
                }
            }
        }
        for (List<Integer> list : map.values()) {
            result.add(list);
        }
        return result;
    }
}
