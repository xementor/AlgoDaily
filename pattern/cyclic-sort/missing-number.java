class Solution {
    public int missingNumber(int[] nums) {
        int i = 0;
        while( i < nums.length ){
            // if number goes beyong our length then drop this.
            if (nums[i] < nums.length && nums[i] != nums[nums[i]]){
                swap(i, nums[i], nums);
            } else {
                i ++;
            }
        }
        
        for (int j = 0; j<nums.length; j++){
            if( j != nums[j]){
                return j;
            }
        }
        return nums.length;
        
    }
    
    void swap(int i, int j, int[] arr){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}