/**
 * Given the head of a singly linked list, return true if it is a palindrome.
 *
 * [1, 2, 2, 1] -> true
 */
class LC234 {
  public boolean isPalindrome(ListNode head) {
    if (head == null) return true;
    // find mid
    ListNode slow = head, fast = head;
    while (fast != null) {
      slow = slow.next;
      if (fast.next == null) {
        fast = null;
      } else {
        fast = fast.next.next;
      }
    }
    // reverse
    ListNode halfHead = reverse(slow);
    while (head != null && halfHead != null) {
      if(head.val != halfHead.val) {
        return false;
      }
      head = head.next;
      halfHead = halfHead.next;
    }
    return true;
  }

  private ListNode reverse(ListNode node) {
    ListNode prev = null, cur = node;
    while (cur != null) {
      ListNode tmp = cur.next;
      cur.next = prev;
      prev = cur;
      cur = tmp;
    }
    return prev;
  }
}