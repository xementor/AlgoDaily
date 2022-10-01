# The isBadVersion API is already defined for you.
def isBadVersion(version: int) -> bool:
    pass

class Solution:
    def firstBadVersion(self, n: int) -> int:
        start = 1
        end = n
        
        while(start <= end):
            mid = (start + end) // 2
            if not isBadVersion(mid):
                start = mid + 1
            else:
                end = mid - 1
            
        print(start, end)
        return start
            
        