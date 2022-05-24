class Solution {
    /*
        Aproach 1: Brute force
        - first permutate the string
        - and check every permuation isValid or not.
        Time Complexity: O(n^3) . permutation(n^2). checking O(n)
    */
    public boolean isValid(String s){
        Stack<Character> stack = new Stack<Character>();
        for( char paren : s.toCharArray()){
            if (paren == '('){
                stack.push(paren);
            } else if (!stack.empty() && stack.peek() == '('){
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.empty();
    }
    public int longestValidParentheses3(String s){
        int maxlen = 0;
        for (int i=0; i < s.length(); i++){
            for ( int j=i+2; j <= s.length(); j += 2){
                if (isValid(s.substring(i,j))){
                    maxlen = Math.max(maxlen, j-i);
                }
            }
        }
        return maxlen;
    }
    
    public int longestValidParentheses(String s){
        int maxans = 0;
        int dp[] = new int[s.length()];
        
        for (int i = 1; i < s.length(); i++){
            if (s.charAt(i) == ')'){
                if(s.charAt(i-1) == '('){
                    dp[i] = (i >= 2 ? dp[i-2] : 0) + 2;
                } else if ( i - dp[i-1] > 0 && s.charAt(i-dp[i-1] -1) == '('){
                    dp[i] = dp[i-1] + ((i - dp[i-1]) >=2 ? dp[i- dp[i-1] -2 ]:0)+2;
                }
                maxans = Math.max(maxans, dp[i]);
            }
        }
        return maxans;
    }
    
    
    
    
    /*
        Aproach Mistaked: first I've though this problem like that.
        Just Ignore...
    */
    public int longestValidParentheses2(String s) {
        Deque<Character> q = new ArrayDeque<Character>();
        
        int len = 0;
        int templen = 0;
        
        for (char paren : s.toCharArray()){
            // if(q.size() < 1){
            //     if (len > templen){
            //         templen = len;
            //         len = 0;   
            //     }
            //     len = 0;
            // }
            
            
            if(q.size() < 1 && paren == '('){
                q.add(paren);
                
            }
            else if(paren == '('){
                q.add(paren);
                
            }else if(q.size() > 0 && paren == ')'){
                q.remove();
                len = len + 2;
            }
        }
        
    return len;
    }
}