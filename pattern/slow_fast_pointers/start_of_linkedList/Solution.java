package pattern.slow_fast_pointers.start_of_linkedList;

import pattern.*;

public class Solution {
   public static ListNode findCycleStart(ListNode head)  {
    int cycleLength = 0;
    ListNode slow = head, fast = head;
    while (fast != null && fast.next != null) {
        fast = fast.next.next;
        slow = slow.next;
        if (slow == fast) {
            cycleLength = caculateCycleLenght(slow);
        }
    }

    return findStart(head, cycleLength);
   }

    private static int caculateCycleLenght(ListNode slow) {
        ListNode current = slow;
        int cycleLength = 0;
        do {
            current = current.next;
            cycleLength ++;
        } while (current != slow);

        return cycleLength;
    }

    private static ListNode findStart(ListNode head, int cycleLength) {
        ListNode pointer1 = head, pointer2 = head;
        while (cycleLength > 0) {
            pointer2 = pointer2.next;
            cycleLength --;
        }

        while (pointer1 != pointer2) {
            pointer1 = pointer1.next;
            pointer2 = pointer2.next;
        }

        return pointer1;
    }
}
