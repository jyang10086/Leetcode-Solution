class LC83 {
  public ListNode deleteDuplicates(ListNode head) {
    // O(n)
    if (head == null || head.next == null){
      return head;
    }
    ListNode cur = head;
    while (cur != null && cur.next != null) {
      if (cur.val == cur.next.val) {
        cur.next = cur.next.next;
      } else {
        cur = cur.next;
      }
    }
    return head;
  }
}