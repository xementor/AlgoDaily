package pattern.inplace_linklist_reversal.reverse_altering_k_element;

import pattern.ListNode;

public class Solution {
  public static ListNode reverse(ListNode head, int k) {
    if ( k <= 1 || head == null) return head;

    ListNode current = head, previous = null;
    while (true) {
      ListNode lastNodeOfPrevPart = previous;
      ListNode lastNodeofSubList = current;
      ListNode next = null;

      for (int i=0; i < k && current != null; i++) {
        next = current.next;
        current.next = previous;
        previous = current;
        current = next;
      }

      if (lastNodeOfPrevPart != null) lastNodeOfPrevPart.next = previous;
      else head = previous;

      lastNodeofSubList.next = current;

      for (int i=0; current != null && i <k; i++) {
        previous = current;
        current = current.next;
      }

      if (current == null) break;
    }

    return head;
  }
}
