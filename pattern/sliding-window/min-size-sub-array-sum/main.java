class MinSizeSubArraySum {
    public static int findMinSubArray(int S, int[] arr) {
        int winSum = 0;
        int winStart = 0;
        int minLength = Integer.MAX_VALUE;
        for (int winEnd = 0; winEnd < arr.length; winStart ++){
            winSum += arr[winEnd];
            if (winSum >= S){
                minLength = Math.min((winEnd - winStart + 1), minLength);
                winSum -= arr[winStart];
                winStart ++;
            }
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    public static void main(String[] args){
        System.out.println(MinSizeSubArraySum.findMinSubArray(7, new int[] {2,1,5,2,3,2}));
        System.out.println(
            MinSizeSubArraySum
                .findMinSubArray(7, 
                new int[] {2,1,5,2,3,2}));

        System.out.println(
            MinSizeSubArraySum
                .findMinSubArray(8, 
                new int[] {2,1,5,2,3,2}));
    }
}