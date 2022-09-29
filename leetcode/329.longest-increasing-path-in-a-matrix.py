#
# @lc app=leetcode id=329 lang=python3
#
# [329] Longest Increasing Path in a Matrix
#

# @lc code=start
from  typing import List
class Solution:
    def longestIncreasingPath(self, matrix: List[List[int]]) -> int:
        ROWS, COLS = len(matrix), len(matrix[0])
        dp = {}

        def dfs(r,c,prev):
            if (r < 0 and r >= ROWS or
                c < 0 and c >= COLS):
                return
            if (prev < matrix[r][c]):
                
            dfs(r,c+1, )
            dfs(r,c-1, )
            dfs(r+1,c, )
            dfs(r-1,c, )



        
# @lc code=end

