class MaxSumSubArrayOfSizeK {
    public static int findMaxSumSubArray(int k , int[] arr){
        /*
         * Time Complexity: O(n * k)
         * space complexity: 1
         */
        int winSum, maxSum = 0;
        for (int i=0; i<arr.length - k; i++){
            // System.out.println(arr[i]);
            winSum = 0;
            for (int j=i; j<i+k; j++){
                winSum += arr[j];
            }
            maxSum = Math.max(winSum, maxSum);
            

        }
        return maxSum;
    }

    public static int findMaxSumSubArray2(int k , int[] arr){
        /*
         * Sliding window aproach
         * My own code
         * 
         */
        int winSum = 0, maxSum = 0;
        for (int i=0; i<arr.length; i++) {
            if (i < k) {
                winSum += arr[i];
                maxSum = Math.max(winSum , maxSum);
                continue;
            }
            else {
                winSum -= arr[i-k];
                winSum += arr[i];
                maxSum = Math.max(winSum , maxSum);
            }
        }
        return maxSum;
    }

    public static int findMaxSumSubArray3(int k , int[] arr){
        /*
         * Aproach sliding window
         * clean code
         * Time complexity: O(n)
         * 
         */
        int winSum = 0, maxSum = 0;
        int winStart = 0;
        for (int winEnd = 0; winEnd < arr.length; winEnd++){
            winSum += arr[winEnd];
            if (winEnd > k) {
                maxSum = Math.max(winSum, maxSum);
                winSum -= arr[winStart];
                winStart ++;
            }
        }
        return maxSum;
    }


    public static void main(String[] args){
        System.out.println("Maximum sum of subarray of size k");
        int result = MaxSumSubArrayOfSizeK.findMaxSumSubArray2(3,
         new int[] { 2, 1, 5 , 1, 2, 34, 5,1});
         System.out.println(result);
    }
}