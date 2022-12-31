from typing import List
class Solution:
    def canPartition(self, numss: List[int]) -> bool:
        def fn(dp,nums, sum, idx):
            if sum == 0:
                return 1
            n = len(nums)
            if n == 0 or idx >= n:
                return 0
            
            if dp[idx][sum] == -1:
                if nums[idx] <= sum:
                    if fn(dp, nums, sum - nums[idx], idx+1) == 1:
                        dp[idx][sum] = 1
                        return 1
                dp[idx][sum] = fn(dp, nums, idx+1)
            return dp[idx][sum]
            
        s = sum(numss)
        
        if s % 2 == 0:
            return False
        
        dp = [[-1 for x in range(len(s/2)+1)] for y in range(len(numss))]
        return True if fn(dp,numss,int(s/2), 0) == 1 else False
        
        
    
    