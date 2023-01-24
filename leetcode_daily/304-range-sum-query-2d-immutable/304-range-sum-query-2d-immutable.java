class NumMatrix {
    /**
     * Aproach 1: Brute force
     * - just go through every element in range.
     */
    int[][] matrix = null;
    
    public void NumMatrix2(int[][] matrix) { //just ignoring construction
        this.matrix = matrix;    
    }
    
    public int sumRegion2(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for (int i = row1; i <= row2; i++){
            for ( int j = col1; j <= col2; j++){
                sum += this.matrix[i][j];
            }
        }
        return sum;
        
    }

    /*
        Arpoach 2: Caching row
        - first go throw every element of a matrix and just create anotehr dp matrix with sum of the row: like add 1st and 2nd element in 2nd col, 2nd and 3rd in 3rd column
        - later in range. take right col - left col
    */
    
    int[][] dp;
    public void NumMatrix3(int[][] matrix){
        if (matrix.length == 0 || matrix[0].length == 0) return;
        dp = new int[matrix.length][matrix[0].length+1];
        
        for (int r = 0; r < matrix.length; r++){
            for (int c = 0; c < matrix[0].length; c++){
                dp[r][c+1] = dp[r][c] + matrix[r][c];
            }
        }
    }
    
    public int sumRegion3(int row1, int col1, int row2, int col2){
        int sum = 0;
        for (int row = row1; row <= row2; row ++){
            sum += dp[row][col2+1] - dp[row][col1];
        }
        return sum;
    }

    public NumMatrix(int[][] matrix){
        if (matrix.length == 0 || matrix[0].length == 0) return;
        dp = new int[matrix.length+1][matrix[0].length+1];

        for (int r = 0; r < matrix.length; r++){
            for (int c = 0; c < matrix[0].length; c++){
                dp[r+1][c+1] = dp[r+1][c] + dp[r][c+1] + matrix[r][c] - dp[r][c];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2){
        return dp[row2+1][col2+1] - dp[row1][col2 +1] - dp[row2+1][col1] + dp[row1][col1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */