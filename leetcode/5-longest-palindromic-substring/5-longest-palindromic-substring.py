"""
    Aproach 1: Brute Force
    - just first permute the string and find all combination 0(n^2)
    - then fint bigger length one 0(n)
    - total time complexity would be O(n^3)

    Curr Aproach 2: left right pointer 
    - keep left and right pointer
    - check left and rigth pointer string is smae or not
    - if yes then spand the left and right pointer. left -- and right ++
"""

class Solution:
    def longestPalindrome(self, s: str) -> str:
        result = []
        length = 0
        
        for i in range(len(s)):
            # event pointer
            l = r = i
            while l >= 0 and r < len(s) and s[l] == s[r]:
                cur_length = r - l + 1;
                if(cur_length > length):
                    result = [l,r]
                    length = cur_length
                l -= 1
                r += 1
            
            # odd pointer
            l  = i;
            r = i+1;
            while l >= 0 and r < len(s) and s[l] == s[r]:
                cur_length = r - l + 1;
                if(cur_length > length):
                    result = [l,r]
                    length = cur_length
                l -= 1
                r += 1
                
        return s[result[0]:result[1]+1]
            
                    
        