package pattern.inplace_linklist_reversal.reverse_sublist;

import pattern.ListNode;

public class Solution {
  private static ListNode reverse(ListNode head, int p, int q) {
    if (p == q) return head;

    ListNode current = head, previous = null;
    for(int i=0; current != null && i < p-1; ++i){
      previous = current;
      current = current.next;
    }

    // [1,2, 3 ,4,5,6, 7 ,5]
    //    l  p         q
    ListNode lastNodeofFirstPart = previous;
    ListNode lastNodeOfSubList = current;
    ListNode next = null;
    
    for (int i = 0; current != null && i < q-p; i++) {
      next = current.next;
      current.next = previous;
      previous = current;
      current = next;
    }

    if (lastNodeofFirstPart != null) lastNodeofFirstPart.next = previous;
    else head = previous;

    lastNodeOfSubList.next = current;
    return head;
  }
}
