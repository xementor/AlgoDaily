class Solution {
    public int lengthOfLIS(int[] nums) {
        int dp[] = new int[nums.length];
        for(int i=0; i<nums.length; i++){
            dp[i] = 1;
        }
        
        for(int i=1; i<nums.length; i++){
            int j = 0;
            while(j <= i){
                if(nums[j] < nums[i]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
                j++;
            }
        }
        
        for(int i=0; i<nums.length; i++){
            System.out.print(dp[i]+" ");
        }
        Arrays.sort(dp);
        return dp[nums.length-1];
    }
}