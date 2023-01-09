package pattern.cyclic_sort.find_smallest_missing;

public class Solution {
  public static int findNumber(int[] nums) {
    int i = 0;
    while (i < nums.length) {
      if (
        nums[i] > 0 && 
        nums[i] <= nums.length && 
        nums[i] != nums[nums[i] - 1]
      )
        swap(nums, i, nums[i] - 1);
      else
        i++;
    }

    for (int num: nums) {
      System.out.println(num);
    }

    for (i = 0; i < nums.length; i++)
      if (nums[i] != i + 1)
        return i + 1;

    return nums.length + 1;
  }

  private static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
  public static void main(String[] args) {
    findNumber(new int[] { 2, 1, 3, 6, 5});
  }
  
}


