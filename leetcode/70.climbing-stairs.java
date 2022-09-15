/*
 * @lc app=leetcode id=70 lang=java
 *
 * [70] Climbing Stairs
 */

// @lc code=start
class Solution {
    public int climbStairs(int n) {
        int one = 1, two = 1;
        
        for (int i = 0; i < n-1; i++){
                int temp = one;
                one = one+two;
                two = temp;
        }

        return one;
        
    }
}
// @lc code=end

