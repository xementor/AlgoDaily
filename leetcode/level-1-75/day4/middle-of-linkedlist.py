from typing import List, Optional
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution:
    def middleNode(self, head: Optional[ListNode]) -> Optional[ListNode]:
        slow = fast = head
        
        while (fast.next != None):
            fast = fast.next.next
            slow = slow.next
        
        return slow

head = ListNode(1,next=ListNode(2, next=ListNode(3, next=ListNode(4, next=ListNode(5)))))

Solution().middleNode(head)