/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class LC25 {
  public ListNode reverseKGroup(ListNode head, int k) {
    /***
     O(n)
     */
    if (head == null || head.next == null || k == 1) return head;
    ListNode dummy = new ListNode(-1, head);
    int cnt = 0;
    ListNode cur = dummy;
    while (cur != null) {
      cur = cur.next;
      cnt++;
    }
    ListNode newList = dummy;
    cur = head;
    // i * k = cnt
    for (int i = 0; i < cnt / k; i++) {
      int tmp = k;
      ListNode subHead = cur; // 1
      while (--tmp > 0) {
        cur = cur.next;
      }
      if (cur == null) break;
      ListNode subTail = cur; // 3
      ListNode nextHead = cur.next; // 4
      reverse(subHead, k); // 0 -> 1 <- 2 <- 3 -> 4
      newList.next = subTail;
      subHead.next = nextHead;
      newList = subHead;
      cur = nextHead;
    }
    return dummy.next;
  }

  private void reverse(ListNode node, int k) {
    ListNode pre = null, cur = node;
    while (k-- > 0) {
      ListNode tmp = cur.next;
      cur.next = pre;
      pre = cur;
      cur = tmp;
    }
  }
}