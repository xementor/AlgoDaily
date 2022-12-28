/*
 * Aproach: Two pointer aproach
 * - 
 * 
 * 
 */
class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int squares[] = new int[n];
        
        int ploaceholder = n - 1;
        
        int left = 0;
        int right = n - 1;
        
        while(left <= right ){
            
            int leftS = nums[left] * nums[left];
            int rightS = nums[right] * nums[right];
            
            if ( leftS > rightS) {
                squares[ploaceholder--] = leftS;
                left ++;
            }else {
                squares[ploaceholder--] = rightS;
                right --;
            }
        }
        return squares;
        
    }
}