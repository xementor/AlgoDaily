package pattern.slow_fast_pointers.happy_number;

public class Solution {
    public static boolean findHappyNumber(int num) {
        int slow = num, fast = num;
        do {
            slow = findSquaredSum(slow);
            fast = findSquaredSum((findSquaredSum(fast)));
        } while (slow != fast);
        return slow == 1;
    }

    public static int findSquaredSum(int num) {
        int sum = 0;
        while (num > 0) {
            int lastDigit = num % 10;
            sum += lastDigit * lastDigit;
            num /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(findHappyNumber(23));
        System.out.println(findHappyNumber(12));
    }
    
}
