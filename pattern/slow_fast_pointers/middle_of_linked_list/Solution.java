package pattern.slow_fast_pointers.middle_of_linked_list;

import pattern.ListNode;

public class Solution {
    /**
     * @param head
     * @return
     */
    public static ListNode findMiddle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    
}
