class Solution:
    def longestPalindromeSubseq(self, s: str) -> int:
        result = lps(s, 0, len(str))
        return result

    def lps(self, st: str, s: int, l:int):
        if l == 0:
            return 0
        if l == 1:
            return 1
        if(st[s] == st[s+l-1]):
            return 2 + lps(st, s+1, l -2)
        else:
            return max(lps(st, s, l-1), lps(st, s+1, l-1))


