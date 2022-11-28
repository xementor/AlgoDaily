from typing import List

class Solution:

    # Aproach 2: I'm not even sure, why this solution work
    def maxArea(self, height: List[int]) -> int:
        res = 0        
        l, r = 0, len(height) - 1
  
        while(l<r):
            res = max(res, (min(height[l], height[r]) * abs(l-r)))
            
            if (height[l] <= height[r]):
                l += 1
            elif height[l] > height[r]:
                r -= 1
                      
        return res
    
    
    
    # Approcha 1: Brut force
    def maxArea2(self, height: List[int]) -> int:
        
        res = 0
        for i, a in enumerate(height):
            for j in range(i+1, len(height)):
                res = max(res, (min(height[i], height[j]) * abs(i-j)))
        
        return res
        