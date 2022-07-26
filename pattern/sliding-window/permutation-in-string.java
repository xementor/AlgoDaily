class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> dic = new HashMap<Character, Integer>();
        int startWin = 0;
        int matched = 0;
        
        for ( char c: s1.toCharArray() )
            dic.put(c, dic.getOrDefault(c,0)+1);
        
        for ( int endWin = 0; endWin < s2.length(); endWin ++ ){
            char right = s2.charAt(endWin);
            
            if (dic.containsKey(right)){
                dic.put(right, dic.get(right) -1);
                
                if( dic.get(right) == 0){
                    matched ++;
                }
                    
                
            }
            
            if (matched == dic.size() ){ 
                return true;
            }
            
            if (endWin >= s1.length() -1){
                char left = s2.charAt(startWin++);
                if(dic.containsKey(left)){
                    if ( dic.get(left) == 0){
                        matched --;
                
                    }
                    dic.put(left, dic.get(left) +1);
                }
            }
        
        
        }
        return false;
}
}