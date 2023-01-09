import pattern.ListNode;

public class Solution {
  public static ListNode ListNode(ListNode head, int k) {
    if (k <= 1 && head == null) return head;

    ListNode current = head, previous = null;
    while (true) {
      ListNode lastNodeOfPreviousPart = previous;
      ListNode lastNodeOfSubList = current;
      ListNode next = null;

      for (int i=0; current != null & i < k; i++) {
        next = current.next;
        current.next = previous;
        previous  = current;
        current = next;
      }

      if (lastNodeOfPreviousPart != null) lastNodeOfPreviousPart.next = previous;
      else head = previous;
      lastNodeOfSubList.next = current;

      if (current == null) break;
    }
    return head;
  }
}
