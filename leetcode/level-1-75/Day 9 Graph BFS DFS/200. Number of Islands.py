class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        R, C = len(grid), len(grid[0])
        
        def dfs(r,c):
            if grid[r][c] == str(1):
                grid[r][c] = str(0)
                if r >= 1: dfs(r-1, c)
                if r+1 < R: dfs(r+1, c)
                if c >= 1: dfs(r, c-1)
                if c+1 < C: dfs(r, c+1)
         
        count = 0
        for i in range(R):
            for j in range(C):
                if grid[i][j] == str(1):
                    count +=1 
                    dfs(i,j)
                    # print(grid)
        
        return count
                
        