class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int winStart = 0;
        double winSum = 0;
        double result = -999;
        
        for(int winEnd = 0; winEnd < nums.length; winEnd ++){
            winSum += nums[winEnd];
            
            if ( winEnd >= k-1 ){
                double avg = winSum/k;
                if(result < avg){
                    result = avg;
                }
                winSum -= nums[winStart];
                winStart ++;
            }
        }
        
        return result;
        
    }
}