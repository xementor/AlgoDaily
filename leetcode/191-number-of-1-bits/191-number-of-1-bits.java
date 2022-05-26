public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        String s = Integer.toBinaryString(n);
        int res = 0;
        for (char c : s.toCharArray()){
            if( c == '1'){
                res ++;
            }
        }
        return res;
    }
}