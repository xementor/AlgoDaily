import java.util.*;
class Solution {
    public boolean hasAllCodes(String s, int k) {
        int need = 1 << k; // 2^k
        Set<String> got = new HashSet<String>();
        
        for (int i = k; i <= s.length(); i++){
            String a = s.substring(i-k,i);
            
            if(!got.contains(a)){
                got.add(a);
                need --;
                if(need == 0){
                    return true;
                }
            }
        }
        // System.out.println(bin);
        return false;
    }
}