class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        res = []
        for i in range(len(s) - len(p) + 1):
            c = [el for el in p]
            j = i
            while j < len(s) and s[j] in c:
                c.remove(s[j])
                j += 1
            if len(c) == 0:
                res.append(i)
                
        return res
                
            
            
        