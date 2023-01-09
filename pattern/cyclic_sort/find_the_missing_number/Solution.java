package pattern.cyclic_sort.find_the_missing_number;

public class Solution {
  public static int findMissingNumber(int[] nums) {
    // cyclic sort
    int i = 0;
    while ( i < nums.length ) {
      int j = nums[i] - 1;
      if (nums[i] == nums[j]) swap(nums, i,j );
      else i++;
    }

    for ( i=0; i < nums.length; i++)
      if (nums[i] != i)
        return i;

    return nums.length;
  }

  private static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
}
