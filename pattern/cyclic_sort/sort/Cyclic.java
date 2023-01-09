package pattern.cyclic_sort.sort;

public class Cyclic {
  public static void sort(int[] nums) {
    int i = 0;
    while (i < nums.length) {
      int j = nums[i]-1;
      if (nums[i] != nums[j]) swap(nums, i,j);
      else i++;
    }
  }

  public static void swap(int[] arr, int i , int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
  public static void main(String[] args) {
    int[] nums = {4,2,1,3};
    sort(nums);
    for( int num: nums) {
      System.out.println(num);  
    }
  }
}
