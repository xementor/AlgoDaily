class Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        def common(first: str, second: str) -> str:
            final = ""
            for i in range(min(len(first),len(second))):
                if first[i] == second[i]:
                    final += first[i]
                else:
                    return final
            return final
        
        res = strs[0]
        for el in strs[1:]:
            res = common(res, el)
        
        return res
        
                    
        