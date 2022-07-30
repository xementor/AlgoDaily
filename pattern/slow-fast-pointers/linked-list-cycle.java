/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

 /*
  * - fast pointer will move 2 node ahead
    - slow pointer will move 1 node ahead
    - if there any cycle the loop by next checking will go infinite
    - but at any point slow and fast pointer will meet.
    - that mean there any cycle exist.
  */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            
            if (slow == fast){
                return true;
            }
            
        }
        return false;
        
    }
}