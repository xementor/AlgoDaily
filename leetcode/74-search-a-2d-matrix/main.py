class Solution:
    def searchMatrix(l, t):
        for m in l:
            for i in m:
                if i==t:
                    return True
        return False    
