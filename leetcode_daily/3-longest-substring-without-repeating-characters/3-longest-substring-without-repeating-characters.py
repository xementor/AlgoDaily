class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        seen = {}
        start = 0
        longest = 0
        for i, c in enumerate(s):
            if c in seen and seen[c] >= start:
                print(seen[c])
                start = seen[c]+1
            else:
                longest = max(longest, i - start +1)
            seen[c] = i
        
        print(seen)
        return longest
            
        