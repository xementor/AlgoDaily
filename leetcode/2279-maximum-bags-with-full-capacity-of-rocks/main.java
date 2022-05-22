    
class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int size = capacity.length;
        int empty[] = new int[size];
        
        for(int i=0; i<size; i++){
            empty[i] = capacity[i] - rocks[i];
            
        }
        Arrays.sort(empty);
        for( int num: empty){
            System.out.print(num + " ");
        }
        
        int index = 0;
        
        while(additionalRocks > 0 && index < size){
            if(empty[index] !=0 && empty[index] <= additionalRocks){
                additionalRocks = additionalRocks -empty[index];
                empty[index] = 0;
                
            }
            index++;
        }
        
        int result = 0;
        for(int val : empty){
            System.out.print(val+" ");
            if ( val == 0) result ++;
        }
        return result;
    }
}