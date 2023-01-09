package pattern.inplace_linklist_reversal.reverse;
import pattern.ListNode;

public class Solution {
  public static ListNode traverse(ListNode head){
    ListNode current = head;
    ListNode previous = null;
    ListNode next = null;

    while (current != null) {
      next = current.next;
      current.next = previous;
      previous  = current;
      current = next;
    }
    return previous;
  }
  
}
