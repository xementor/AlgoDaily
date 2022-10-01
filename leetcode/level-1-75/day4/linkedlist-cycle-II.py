# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def detectCycle(self, head: Optional[ListNode]) -> Optional[ListNode]:
        h = head
        def calculateLength(slow):
            current = slow.next
            l = 0
            while(current != slow):
                current = current.next
                l += 1
            return l
        def isCycle(head):
            slow = head
            h = head
            while head and head.next:
                slow = slow.next
                head = head.next.next
                if slow == head:
                    print(head.val)
                    return calculateLength(slow)
            return -1
        
        length  = isCycle(head)
        print(length)
        if length < 0:
            return None
        
        ptr1 = ptr2 = h
        for _ in range(length+1):
            ptr2 = ptr2.next
        print(ptr1.val)
        print(ptr2.val)
        
        while(ptr1 != ptr2):
            ptr1, ptr2 = ptr1.next, ptr2.next
        
        return ptr1
            
        