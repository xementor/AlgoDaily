package pattern.cyclic_sort.find_duplicate;

public class Solution {
  public static int findDuplicateNumber(int[] nums) {
    int i = 0;
    while (i < nums.length) {
      if (nums[i] != i+1) {
        int j = nums[i] -1;
        if (nums[i] != nums[j]) swap(nums, i , j);
        else return nums[i];
      }
      else i++;
    }

    return 1;
  }
  private static void swap(int[] nums, int i, int j) {
  }
  public static void main(String[] args) {
    int[] nums = new int[] {2, 1, 3,3, 3, 5, 4};
    findDuplicateNumber(nums);
    for(int i=0; i<nums.length; i++) {
      System.out.println(nums[i]);
    }
  }
}

