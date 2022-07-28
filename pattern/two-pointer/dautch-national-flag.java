class Solution {
    public void sortColors(int[] nums) {
        int low = 0;
        int high = nums.length -1;
        
        for(int i=0; i <= high;){ // you cann't itterate all the array,  you have to itterate to high.
            if (nums[i] == 0){
                swap(nums, i, low);
                i++;
                low++;
                
            } else if ( nums[i] == 1){
                i++;
            } else {
                swap(nums, i, high);
                high --;
            }
        }
        
    }
    
    void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}