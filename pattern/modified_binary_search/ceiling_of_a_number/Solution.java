package pattern.modified_binary_search.ceiling_of_a_number;

public class Solution {
  public static int searchCeilingOfANumber(int[] arr, int key){
    int start = 0, end = arr.length -1;
    while (start < end) {
      int mid = start + (end - start) / 2;
      if (key == arr[mid]) return mid;
      if (key < arr[mid]) end = mid - 1;
      if (key > arr[mid]) start = mid + 1;
    }
    return start;
  }
  
}
