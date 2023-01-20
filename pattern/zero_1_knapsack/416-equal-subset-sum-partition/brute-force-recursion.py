from typing import List
class Solution:
    def canPartition(self, numss: List[int]) -> bool:
        
        def fn(nums, s, indx):
            n = len(nums)
            if n==0 or indx >= n:
                return False

            if nums[indx] <= s:
                if(fn(nums, s - nums[indx], indx+1)):
                    return True
            return fn(nums, s, indx+1)
    
        s = sum(numss)
        if s % 2 != 0:
            return False
        
        return fn(numss, s/2, 0)
    
    