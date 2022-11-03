import re
class Solution:
    def isPalindrome(self, s: str) -> bool:
        # Use regular expression to remove non-alphaneumerical value
        s = re.sub(r'[^a-zA-Z0-9]', '', s).lower()
        
        # start looping from first and last of the string
        # two pointer
        # if first and last pointer is true
        # then increment i and decrement j
        i,j = 0, len(s) -1
        
        while(i < j):
            if s[i] == s[j]:
                i += 1
                j -= 1
            else:
                return False
        return True
        