class Solution:
    def isPalindrome(self, x: int) -> bool:
        """
        Check some edge case.
        """
        if x < 0 or (x % 10 == 0 and x != 0):
            return False
        
        reverted_number: int = 0
        
        while(x > reverted_number):
            reverted_number = reverted_number * 10 + x % 10
            x //= 10
        
        print(reverted_number)
        return x == reverted_number or x == reverted_number // 10
        