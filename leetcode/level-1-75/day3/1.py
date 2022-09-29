from typing import List, Optional

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def mergeTwoLists(self, list1: Optional[ListNode], list2: Optional[ListNode]) -> Optional[ListNode]:
        
        result = head = ListNode(None)
        

        while(list1.next != None or list2.next != None):
            if list1.val <= list2.val:
                result.next = list1
                list1 = list1.next
                result = result.next
            else:
                result.next = list2
                list2 = list2.next
                result = result.next
        
            
        while(not list1):
            result.next = list1
            list1 = list1.next
            result = result.next


        while(not list2):
            result.next = list2
            list2 = list2.next
            result = result.next
                
            
        return head.next

list1 = ListNode(1,next=ListNode(2, next=ListNode(4)))
list2 = ListNode(1,next=ListNode(3, next=ListNode(4)))

Solution().mergeTwoLists(list1, list2)