class Solution {
    /*
       1.First Aproach was to srink my array by binary search.
        what wrong with this aproach?
        - none wrong, but it would be some optimization.
        - but implement get preoblemetic , why? am noob. hope Allah will make be better.
        
        2. Second Thinking was resetting left pointer to zero.
            why?
            - my thought was may be if i don't reset left pointer then result will be false, as thinking was it also can be solution.
            - but actually not.
            = So I've to think more carefully the solution.
        
        3. Discussion solution:
            - Just my second thinking was worng. but overall idea is same.
            - additionally checked base case.
        4. My learning.
            - Think problem very deeply.
            - try to come up with solution.
            - write this solution
            - try to optimize.
        
        Thank you
    */
    public int[] twoSum(int[] num, int target) {
        int[] indice = new int[2];
        if ( num == null || num.length < 2) return indice; 
        
        int left = 0 , right = num.length -1;
        
        while (left < right) {
            
            int v = num[left] + num[right];
            
            if (v == target) {
                indice[0] = left + 1;
                indice[1] = right + 1;
                break;
            }
            else if (v < target) {
                left ++;
            } else {
                right --;
                
            }
        }
        
        return indice;
        
    }
}