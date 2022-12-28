class ReplacingOne {
    public static int findLength(int[] arr, int k) {
        // TODO: Write your own code
        int winStart = 0, maxOnesCount = 0, maxLength = 0;
        for (int winEnd = 0; winEnd < arr.length; winEnd++) {
            // Need to count of 1 in the current window
            if (arr[winEnd] == 1) {
                maxOnesCount ++;
            }

            // If in current window, number of 0 greater than k
            // we need to update window size
            if ((winEnd-winStart+1) - maxOnesCount > k){
                if (arr[winStart] == 1)
                    maxOnesCount--;
                winStart ++;
            }
            maxLength = Math.max((winEnd - winStart + 1), maxLength);
        }
        return maxLength;
    }
}