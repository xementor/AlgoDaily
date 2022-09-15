/*
 * @lc app=leetcode id=198 lang=java
 *
 * [198] House Robber
 */

// @lc code=start
class Solution {

    public int rob(int[] nums) {
        int rob1 = 0, rob2 = 0;

        for(int num: nums){
            int temp = Math.max(num+rob1, rob2);
            rob1 = rob2;
            rob2 = temp;
            
        }

        return Math.max(rob1, rob2);
    }

    public int rob2(int[] nums) {
        if (nums.length == 1) return nums[0];
            
        int last_idx = nums.length - 1;
        int two = nums[last_idx];

        int one = Math.max(two, nums[last_idx-1]);

        for (int i=last_idx -2; i >= 0; i--){
            int temp = one;
            one = Math.max(nums[i]+two, one);
             two = temp;
        }

        return Math.max(one,two);


        
    }
}
// @lc code=end

