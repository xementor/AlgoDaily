class Solution {
    public int percentageLetter(String s, char letter) {
        double count =0, size = s.length(); 
        
        for (int i=0; i<size; i++){
            if(s.charAt(i) == letter){
                count++;
            }
        } 
        
        return (int)((count/size) * 100);
        
    }
}