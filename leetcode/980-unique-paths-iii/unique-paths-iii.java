/*
    Aproach : DFS | Recursion | backtracking
    - first find start , end , and obstracle number by broatforach.
    - then dfs recursion.
    - basecase is , when in end box then check all the box are visisted or not.
    - for a cell go 4 direction and when go to the next level increase visted cell
*/
class Solution{
    private static final int[][] DIRECTIONS = {{0,-1},{-1,0},{0,1},{1,0}};
    
    public int uniquePathsIII(int[][] grid){
        if (grid == null || grid.length == 0){
            return 0;
        }
        int n = grid.length, m = grid[0].length, obstacles = 0;
        int[] start = null, end = null;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if (grid[i][j] == -1){
                    obstacles++;
                } else if (grid[i][j] == 1){
                    start = new int[] {i,j};
                } else if (grid[i][j] == 2){
                    end = new int[] {i,j};
                }
            }
        }

        int totalCellsToBeIncludedInPath = n * m - obstacles;

        if ( start == null || end == null){
            return 0;
        }

        return dfs(grid, start[0], start[1], n, m, end, 1, totalCellsToBeIncludedInPath);
    }

    public int dfs(int[][] grid, int i, int j, int n, int m, int[] end, int cellVisited + 1, int totalCellsToBeIncludedInPath){
        if (i == end[0] && j == end[1]){
            return cellVisited == totalCellsToBeIncludedInPath ? 1 : 0;
        }

        grid[i][j] = -1;
        int result = 0;
        for (int[] move : DIRECTIONS){
            int nextI = move[0];
            int nextJ = move[1];
            if(isValidMove(nextI, nextJ, n, m) && grid[nextI][nextJ] != -1){
                result += dfs(grid, nextI, nextJ, n, m, end, cellVisited, totalCellsToBeIncludedInPath);
            }
        }

        grid[i][j] = 0;
        return result;
    }

    public boolean isValidMove(int i, int j, int n, int m){
        return i >= 0 && i < n && j >= 0 && j < m;
    }

    

}