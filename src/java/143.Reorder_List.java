class LC143 {
  /***
   * You are given the head of a singly linked-list. The list can be represented as:
   *
   * L0 → L1 → … → Ln - 1 → Ln
   * Reorder the list to be on the following form:
   *
   * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
   * You may not modify the values in the list's nodes. Only nodes themselves may be changed.
   *
   * Example 1:
   * Input: head = [1,2,3,4]
   * Output: [1,4,2,3]
   *
   *
   * Example 2:
   * Input: head = [1,2,3,4,5]
   * Output: [1,5,2,4,3]
   *
  public void reorderList(ListNode head) {
    /***
     1. reverse the half
     2. merge
     time: O(n)
     */
    if (head == null || head.next == null) return;
    ListNode slow = head, fast = head;
    while (fast.next != null && fast.next.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    ListNode tail = reverse(slow);
    merge(head, tail);
    return;
  }
  private ListNode reverse(ListNode node) {
    ListNode prev = null, cur = node;
    while (cur !=  null) {
      ListNode tmp = cur.next;
      cur.next = prev;
      prev = cur;
      cur = tmp;
    }
    return prev;
  }
  private void merge(ListNode a, ListNode b) {
    while(a != null && b != null) {
      ListNode tmp1 = a.next;
      ListNode tmp2 = b.next;
      a.next = b;
      b.next = tmp1;
      a = tmp1;
      b = tmp2;
    }
  }
}