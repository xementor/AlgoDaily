from typing import List

class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        if(len(nums) < 1):
            return 0
        nums.sort()
        
        
        max_res = 1
        local_max = 1
        prev = nums[0]
        
        for i in range(1, len(nums)):
           
            if (nums[i] == prev + 1):
                local_max += 1
                max_res = max(local_max, max_res)
                prev = nums[i]
            elif (nums[i] == prev):
                prev = nums[i]
            
            else:
                prev = nums[i]
                local_max = 1
                
        return max_res
        
            
        