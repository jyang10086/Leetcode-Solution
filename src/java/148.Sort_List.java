class LC148 {
  public ListNode sortList(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode slow = head, fast = head.next;
    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
    }
    ListNode mid = slow.next;
    slow.next = null;
    ListNode left = sortList(head);
    ListNode right = sortList(mid);
    return mergeSort(left, right);
  }

  private ListNode mergeSort(ListNode l1, ListNode l2) {
    ListNode dummy = new ListNode(-1);
    ListNode cur = dummy;
    while (l1 != null && l2 != null) {
      if (l1.val <= l2.val) {
        cur.next = l1;
        l1 = l1.next;
      } else {
        cur.next = l2;
        l2 = l2.next;
      }
      cur = cur.next;
    }
    if (l1 != null) cur.next = l1;
    if (l2 != null) cur.next = l2;
    return dummy.next;
  }
}