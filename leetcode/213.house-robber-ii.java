/*
 * @lc app=leetcode id=213 lang=java
 *
 * [213] House Robber II
 */

// @lc code=start
class Solution {
    public int rob(int[] nums) {

        if (nums.length == 1) return  nums[0];

        int first_array_ans = helper(Arrays.copyOfRange(nums,0,nums.length-1));
        int second_array_ans = helper(Arrays.copyOfRange(nums,1,nums.length));
        // System.out.println(first_array_ans);
        // System.out.println(second_array_ans);
        int result = Math.max(
            first_array_ans, 
            second_array_ans
        );
        // System.out.println(result);
        return  result;
        
    }

    public int helper(int[] nums) {
        int rob1 = 0, rob2 = 0;

        for(int num: nums){
            int temp = Math.max(num+rob1, rob2);
            rob1 = rob2;
            rob2 = temp;
            
        }

        return Math.max(rob1, rob2);
    }
}
// @lc code=end

