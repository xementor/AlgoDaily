class Solution(object):
    def uniquePathsWithObstacles(self, obstacleGrid):
        """
        brute force, bottom-up recursively with memorization
        - intuitively go through all the path with i+1 or j+1
        - count the path with reaches to the destination coordinate (m,n)
        - cache the count of the coordinate which we have calculated before
        - if the current grid, grid[i][j], is bloked, tell it's parent that this way  is blocked by return 0
        - sum up all the coordinates count
        
        Time 0(row*col) since we caches the intermediate coordinate, we won't go through the visited coordinates again
        Space 0(row*col) depth of recursions.
        :type obstacleGrid: List[List[int]]
        :rtype: int
        """
        
        if(len(obstacleGrid) == 0 or len(obstacleGrid[0]) ==0):
            return 0
        
        seen = {}
        return self.dfs(obstacleGrid, 0, 0, len(obstacleGrid)-1, len(obstacleGrid[0])-1, seen)
    
    def dfs(self, obstacleGrid, i, j, m, n,seen):
        key = str(i)+","+str(j)
        if key in seen:
            return seen[key]
        
        if(i==m and i==n):
            if(obstacleGrid[i][j]==1):
                return 0;
            return 1;
        
        elif(i>m or j>n):
            return 0;
        
        if obstacleGrid[i][j] == 1:
            seen[key] = 0
            return 0
        left = self.dfs(obstacleGrid, i+1,j, m,n, seen)
        right = self.dfs(obstacleGrid, i, j+1, m,n, seen)
        seen[key] = left+right
        return left + right
        
        