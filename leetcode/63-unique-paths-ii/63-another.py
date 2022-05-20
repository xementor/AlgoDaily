class Solution:
    def uniquePathsWithObstacles(self, obstacleGrid: List[List[int]]) -> int:
        R,C = len(obstacleGrid), len(obstacleGrid[0])
        
        @lru_cache(maxsize=None)
        def dp(r:int, c:int)->int:
            if r == R-1 and c == C-1 and obstacleGrid[r][c] == 0:
                return 1
            if r >= R or c >= C or obstacleGrid[r][c] == 1:
                return 0
            return dp(r+1,c) + dp(r,c+1)
        return dp(0,0)