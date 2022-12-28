public class Solution {
    public static int removeDuplicates(int[] arr) {
        // TODO: Write your own code
        int nextNonDuplicate = 1;
        for (int i=1; i<arr.length; i++) {
            if (arr[nextNonDuplicate -1] != arr[i]) {
                arr[nextNonDuplicate] = arr[i];
                nextNonDuplicate++;
            }
        }
        return nextNonDuplicate;
    }

    public static int removeDuplicates2(int[] arr) {
        int nextNonDuplicate = 1;
        for (int i=1; i<arr.length; i++) {
            if (arr[nextNonDuplicate -1] != arr[i]) {
                arr[nextNonDuplicate] = arr[i];
                nextNonDuplicate++;
            }
        }
        return nextNonDuplicate;
    }

    public static void main(String[] args) {
        Solution.removeDuplicates(new int[] {12,2,3,3,2,1});
    }
    
}
