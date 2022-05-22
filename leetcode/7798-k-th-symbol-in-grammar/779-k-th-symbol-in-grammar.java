class Solution {
   
    public int kthGrammar(int n, int k) {
        
        return solve(n, k);
    }
    
    
    int solve(int n, int k){
        
        if(n == 1)
            return 0;
        
        int prev = solve(n - 1, (k + 1)/2);
        
        if( k % 2  == 0){
            //return second digit
            return prev == 0 ? 1 : 0;
        } else {
            //return first digit
            return prev == 0 ? 0 : 1;
        }
        
    }
}
