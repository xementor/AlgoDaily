package pattern.cyclic_sort.find_all_missing_number;

import java.util.ArrayList;
import java.util.List;

public class Solution {
  public static List<Integer> findNumbers(int[] nums) {
    var missingNumbers = new ArrayList<Integer>();
    int i = 0;
    while (i < nums.length) {
      int j = nums[i]-1;
      if (nums[i] != nums[j]) swap(nums, i, j);
      else i++;
    }

    for (i = 0; i < nums.length; i++) {
      if (nums[i] != i+1) {
        missingNumbers.add(i+1);
      }
    }

    return missingNumbers;
  }

  private static void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }
  public static void main(String[] args) {
    int[] nums = new int[] {4,4,1,2,3};
    for (int num :findNumbers(nums)) {
      System.out.println(num);
    }
  }
}
