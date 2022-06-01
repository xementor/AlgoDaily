class Solution {
    /**
     * Aproach : while
     * - As matrix is shorted, so if we start from top right corner of matrix
     * - then if target is grater then my tl(top lep) then this is value is not in this row; so row++;
     * - if the target is less than tl. then the value is not in this col; so col--;
     * 
     * Aproach: Brute force
     * - check all the value of matrix.
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        
         if(matrix == null || matrix.length < 1 || matrix[0].length <1) {
            return false;
        }
        
        int row = 0;
        int col = matrix[0].length - 1;
        
        while(col >= 0 && row <= matrix.length -1){
            if(matrix[row][col] == target){
                return true;
            }
            else if(target > matrix[row][col]){
                row++;
            }
            else if(target < matrix[row][col]){
                col--;
            }
        }
       return false;
    }
    
}