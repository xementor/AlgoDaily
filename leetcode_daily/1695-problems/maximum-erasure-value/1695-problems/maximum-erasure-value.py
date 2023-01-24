class Solution:
    """
        This problem kind of leetcode problem 3
        I can improve this solution just taking precalculated sum value
        i will substract value 
    """
    def maximumUniqueSubarray(self, nums: List[int]) -> int:
        seen = {}
        result = 0
        start = 0
        
        dp = [0]
        for j, x in enumerate(nums):
            dp.append(dp[j] + nums[j])
        res = []
        for i, num in enumerate(nums):
            if num in seen and seen[num] >= start:
                start = seen[num] + 1
            # dp.insert(i+1,dp[i+1] - dp[start] )
            res.append(dp[i+1] - dp[start])
            result = max(result, res[i])
            seen[num] = i
        return result
     
        