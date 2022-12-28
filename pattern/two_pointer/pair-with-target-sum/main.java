import java.util.HashMap;
import java.util.Map;

class PairWithTargetSum {
    public static int[] search(int[] arr, int targetSum) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int currentSum = arr[left] + arr[right];
            if (currentSum == targetSum) {
                return new int[] {left, right};
            }

            if (targetSum > currentSum)
                left ++;
            else
                right --;

        }
        return new int[] { -1, -1};
    }

    /**
     * @param arr
     * @param targetSum
     * @return
     */
    public static int[] search2(int[] arr, int targetSum) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i < arr.length; i++) {
            if (map.containsKey(targetSum - arr[i]))
                return new int[] {map.get(targetSum - arr[i]), i};
            else
                map.put(arr[i], i);
        }
        return new int[] {-1, -1};
    }
}