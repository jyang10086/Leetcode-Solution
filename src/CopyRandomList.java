import java.util.HashMap;
import java.util.Map;

public class CopyRandomList {
    class Node {
        public int val;
        public Node next;
        public Node random;

        public Node() {
        }

        public Node(int _val, Node _next, Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    }

    ;
    Map<Node, Node> map = new HashMap<>();

    public Node solutionOne(Node head) {
        //space：O(n) time:O(n)
        if (head == null) return null;
        Node node = head;
        while (node != null) {
            Node newNode = new Node(node.val, null, null);
            node = node.next;
        }
        node = head;
        while (node != null) {
            map.get(node).next = map.get(node.next);
            map.get(node).random = map.get(node.random);
            node = node.next;
        }
        return map.get(head);
    }

    public Node solutionTwo(Node head) {
        if (head == null) return null;
        Node node = head;
        while (node != null) {
            Node next = node.next;
            Node copy = new Node(node.val, next, null);
            node.next = copy;
            node = next;
        }
        node = head;
        while (node != null) {
            if (node.random != null) {
                node.next.random = node.random.next;
            }
            node = node.next.next;
        }

        node = head;
        Node copyHead = node.next;
        while (node != null) {
            Node next = node.next.next;
            Node copy = node.next;
            node.next = next;
            if (next != null) {
                copy.next = next.next;
            }
            node = node.next;
        }
        return copyHead;

    }
}
