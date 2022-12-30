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
public class Solution {
    public ListNode detectCycle(ListNode head) {
        
       ListNode slow = getSlow(head);
        if(slow == null)
            return null;
        
        int cycleLength = cycleLength(slow);
        
        
        ListNode pointer1 = head;
        ListNode pointer2 = head;
        
        // move pointer2 ahad of cycleLength Node
        while(cycleLength > 0){
            pointer2 = pointer2.next;
            cycleLength --;
        }
        
        // now wher two pointer will meet this is the start of linked list
        while(pointer1 != pointer2 ){
            pointer1 = pointer1.next;
            pointer2 = pointer2.next;
        }
        
        return pointer1;
        
    }
    
    // get the length of current cycle
    int cycleLength(ListNode slow){
        int length = 0;
        ListNode current = slow;
        do{
            current = current.next;
            length ++;
            
        } while(slow != current);
        
        return length;
    }
    
    // check if there any cycle exist or not. if yes. then return slow pointer.
    ListNode getSlow(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(slow == fast){
                return slow;
            }
        }
        return null;  
    }
}