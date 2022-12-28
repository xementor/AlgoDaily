package pattern.two_pointer.triplet_sum_zero;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static List<List<Integer>> searchTriplets(int[] arr) {
        List<List<Integer>> triplets = new ArrayList<>();

        // Loop thourhg the arr and pass el to get pair
        for (int i=0; i <arr.length; i++) {
            if (i > 0 && arr[i] == arr[i-1])
                continue;
            searchPair(arr, -arr[i], i+1, triplets);
        }
        return triplets;
    }

    static void searchPair(
        int[] arr, 
        int targetSum, 
        int left, 
        List<List<Integer>> triplets
        ) {
            int right = arr.length -1;
            while (left < right) {
                int currentSum = arr[left] + arr[right];
                if (currentSum == targetSum) {
                    triplets.add(Arrays.asList(-targetSum, arr[left], arr[right]));
                    left ++;
                    right --;
                    while (left < right && arr[left] == arr[left -1]) left ++;
                    while (left < right && arr[right] == arr[right+1]) right --;
                } else if (targetSum > currentSum) right --;
                else right --;
            }


    }

}
