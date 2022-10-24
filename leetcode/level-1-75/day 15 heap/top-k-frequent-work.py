from typing import List
from collections import Counter
class Solution:
    def topKFrequent(self, words: List[str], k: int) -> List[str]:
        wc = Counter(words)
        wc = sorted(wc,key=lambda x : (-wc[x],x))
        return wc[:k]