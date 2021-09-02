 /**
  * 138. Copy List with Random Pointer
  **/
class LC138 {
  public Node copyRandomList(Node head) {
    if (head == null) return null;
    Node cur = head;
    while (cur != null) {
      Node copy = new Node(cur.val);
      Node tmp = cur.next;
      cur.next = copy;
      copy.next = tmp;
      cur = tmp;
    }
    cur = head;
    while(cur!= null && cur.next != null) {
      if (cur.random != null) {
        cur.next.random = cur.random.next;
      }
      cur = cur.next.next;
    }
    cur = head;
    Node copyHead = head.next;
    while(cur.next != null) {
      Node tmp = cur.next;
      cur.next = cur.next.next;
      cur = tmp;
    }
    return copyHead;
}
}