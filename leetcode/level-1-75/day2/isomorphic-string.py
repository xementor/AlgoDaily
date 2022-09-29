class Solution:
    def isIsomorphic(self, s: str, t: str) -> bool:
        map = {}
        map2 = {}
        for i in range(len(s)):
            if not map.get(s[i]) and not map2.get(t[i]) :
                map[s[i]] = t[i]
                map2[t[i]] = s[i]
           
                
            
            elif map.get(s[i]) != t[i] or map2.get(t[i]) != s[i]:
                return False
        return True
            
                                             
        
            