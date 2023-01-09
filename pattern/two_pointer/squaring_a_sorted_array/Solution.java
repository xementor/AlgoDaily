package pattern.two_pointer.squaring_a_sorted_array;

class Solution {
    public static int[] makeSquares(int[] arr) {
        int[] squares = new int[arr.length];
        int idx = 0;
        int left = 0, right = arr.length -1;
        while(left < right) {
            int leftSqrt = arr[left] * arr[left];
            int rightSqrt = arr[right] * arr[right];
            if (leftSqrt < rightSqrt) {
                squares[idx++] = leftSqrt;
                left ++;
            } else {
                squares[idx++] = rightSqrt;
                right --;
            }
        }

        return squares;
    }
    public static void main(String[] args) {
        int res[] = Solution.makeSquares(new int[] {-3,-2,-1,0,2,3});
        for (int val:  res) {
            System.out.println(val);

        }
    }
    
}
