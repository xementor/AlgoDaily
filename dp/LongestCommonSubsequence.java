public class LongestCommonSubsequence {
  public static int longestIncreasingSubsequence(int[] nums) {
    int[] lis = new int[nums.length];
    for (int i = nums.length -1; i >= 0; i--) {
      for (int j = i+1; j < nums.length; j++) {
        if (nums[i] < nums[j]) {
          lis[i] = Math.max(1+lis[j], 1);
        }
      }
    }
    return lis[0];
  }
}
