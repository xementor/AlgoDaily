from typing import List
from math import sqrt
class Solution:
    def mergeArrays(self, nums1: List[List[int]], nums2: List[List[int]]) -> List[List[int]]:
        i, j = 0, 0
        res = []
        while i < len(nums1) and j < len(nums2):
            if nums1[i][0] < nums2[j][0]:
                res.append(nums1[i])
                i += 1
            else:
                res.append(nums2[j])
                j += 1
        while i < len(nums1):
            res.append(nums1[i])
            i += 1
        while j < len(nums2):
            res.append(nums2[j])
            j += 1
        return res
    

    def minOperations(self, n: int) -> int:
      i = 0
      def rec(n, i):
        if n == 0:
            return i
        num = 1
        while num < n:
            num  *= 2
        upper = num
        lower = int(num / 2)
        lower_diff = abs(n - lower)
        upper_diff = abs(n - upper)
        i += 1
        # print(i)
        nn = min(lower_diff, upper_diff)
        return rec(nn, i)
      return rec(n, i)
    
    def checkSqureFree(self, el) -> bool:
        pr = 1
        for l in el:
            pr *= l
        if sqrt(pr).is_integer():
            return True
        return False
      
        

nums1 = [[2,4],[3,6],[5,5]]
nums2 = [[1,3],[4,3]]
s1 = Solution()
s1.mergeArrays(nums1, nums2)
print(s1.checkSqureFree([]))
print(s1.checkSqureFree([1]))
print(s1.checkSqureFree([2]))
print(s1.minOperations(54))
                