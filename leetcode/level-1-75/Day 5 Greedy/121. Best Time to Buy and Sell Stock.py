class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        res = 0
        
        minimum = prices[0]
        for i in range(1,len(prices)):
            if prices[i] > minimum:
                profit = prices[i] - minimum
                res = max(res, profit)
            minimum = min(prices[i], minimum)
            # print(curMin)
            
        return (res)