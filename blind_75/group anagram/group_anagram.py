from collections import defaultdict
from typing import List

# 0(m.n.26)
class Solution:
    def groupAngrams(self, strs: List[str]) -> List[List[str]]:
        res = defaultdict(list)

        for s in strs:
            count = [0] * 26
            for c in s:
                count[ord(c) - ord('a')] += 1
            res[tuple(count)].append(s)

        return res.values()

# O(m.n.logn)
# nlongn for sorting each string
# m is the number of string

# My Default solution 
class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        
        map = {}
        
        for el in strs:
            sel = "".join([str(i) for i in sorted(el)])
            if map.get(sel):
                map[sel].append(el)
            else:
                map[sel] = [el]
                
       
        
        return map.values()
