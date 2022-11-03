from typing import Optional, ListNode
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
        """
            Our aproach will be
            - first get length of the linked list
            - then substructing n , we will get the node, which need to remove.
            - then we will from the node which need to removed, from its before node. just make its next = next.next
            -  [prev] [have to delete node] [after]
            - connect prev.next = after 
            - some edge case should be considered
        """
        
        last = head
        l = 0
        while (last):
            last = last.next
            l += 1
            

        havetogo = l - n
        
        if havetogo == 0:
            head = head.next
            return head
            
        print(havetogo)
        
        if l == havetogo:
            head = head.next
            return head
            
        if l == 1:
            return None
        
        slow = head
        c = 0
        while (c < havetogo - 1):
            slow = slow.next
            c += 1
        slow.next = slow.next.next
        return head
        
            