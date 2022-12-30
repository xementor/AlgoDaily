package pattern.two_pointer.triplet_with_smaller_sum;
import java.util.Arrays;

public class Solution {
    public static int searchTriplets(int arr[], int target) {
        Arrays.sort(arr);
        int count = 0;
        for (int i=0; i < arr.length - 2; i++) {
            count += searchPair(arr, target - arr[i], i);
        }
        return count;
    }

    private static int searchPair(int[] arr, int targetSum, int first) {
        int count = 0;
        int left = first + 1, right = arr.length -1;
        while (left < right)  {
            if (arr[left] + arr[right] < targetSum) {
                count += right - left;
                left ++;
            }
            else right --;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(searchTriplets(new int[] {2,3,4,3,2,3}, 21));
    }
    
}
