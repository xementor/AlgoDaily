from heapq import *
import heapq
class Solution(object):
    def lastStoneWeight(self, stones):
        """
        :type stones: List[int]
        :rtype: int
        """
        h = [-x for x in stones]
        heapq.heapify(h)
        
        while len(h) > 1 and h[0] != 0:
            heapq.heappush(h, heappop(h)- heappop(h))
        
        return -h[0]