/*
 * @lc app=leetcode id=746 lang=java
 *
 * [746] Min Cost Climbing Stairs
 */

// @lc code=start
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int two = cost[cost.length-1];
        int one = cost[cost.length-2];

        for (int i = cost.length - 3; i >= 0; i--){
            int temp = one;
            one = cost[i] +  Math.min(one, two);
            two = temp;
        }

        return Math.min(one,two);


        
    }
}
// @lc code=end

