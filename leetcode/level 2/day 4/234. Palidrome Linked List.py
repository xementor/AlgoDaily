# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        c = head
        length = 0
        
        arr = []
        
        while c:
            arr.append(c.val)
            c = c.next
            length += 1
        
        left = right = ""
        half = length //2
        if length % 2 == 0:
            for i in range(len(arr)):
                if i < half:
                    left += str(arr[i])
                elif i >= half:
                    right += str(arr[i])
        else:
            for i in range(len(arr)):
                if i < half:
                    left += str(arr[i])
                elif i > half:
                    right += str(arr[i])
            

        print(left)
        print(right)
        return True if left == right[::-1] else False 
        
        
        # if length % 2 == 0:
        #     while 
            
        print(length)
        