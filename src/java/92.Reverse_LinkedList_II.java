class LC92 {
  /***
   * Given the head of a singly linked list and two integers left and right where left <= right,
   * reverse the nodes of the list from position left to position right, and return the reversed list.
   *
   *
   * Input: head = [1,2,3,4,5], left = 2, right = 4
   * Output: [1,4,3,2,5]
   */
  public ListNode reverseBetween(ListNode head, int left, int right) {
    if (head == null || head.next == null || left == right) return head;
    ListNode dummy = new ListNode(-1, head);
    ListNode l = head, prev = dummy;
    while (--left > 0) {
      prev = l;
      l = l.next;
    }
    ListNode r = head;
    while (--right > 0) {
      r = r.next;
    }
    ListNode tmp = r.next;
    reverse(l, r);
    prev.next = r;
    l.next = tmp;
    return dummy.next;
  }
  private void reverse(ListNode head, ListNode tail) {
    ListNode prev = null, cur = head;
    while (cur != tail) {
      ListNode tmp = cur.next;
      cur.next = prev;
      prev = cur;
      cur = tmp;
    }
    cur.next = prev;
  }
}