package smallest_range;

import java.util.List;
import java.util.PriorityQueue;

class Node {
  int elidx;
  int arridx;
  Node(int elidx, int arridx) {
    this.elidx = elidx;
    this.arridx = arridx;
  }
}
public class Solution {
  public static int[] findKthSmallestRange(List<Integer[]> lists) {
    PriorityQueue<Node> minHeap = 
      new PriorityQueue<>(
        (n1,n2) -> lists.get(n1.arridx)[n1.elidx]- lists.get(n2.arridx)[n2.elidx]
      );
    
    int rangeStart = 0, rangeEnd = Integer.MAX_VALUE, currentMax = 0;
    for (int i=0; i < lists.size(); i++)
      if (lists.get(i) != null) {
        minHeap.add(new Node(0,i));
        currentMax = Math.max(currentMax, lists.get(i)[0]);
      }
    
    while (minHeap.size() == lists.size()) {
      var node = minHeap.poll();
      if (rangeEnd - rangeStart > currentMax - lists.get(node.arridx)[node.elidx]) {
        rangeStart = lists.get(node.arridx)[node.elidx];
        rangeEnd = currentMax;
      }

      node.elidx++;
      if (lists.get(node.arridx).length > node.elidx) {
        minHeap.add(node);
        currentMax = Math.max(currentMax, lists.get(node.arridx)[node.elidx]);
      }
    }
    return new int[] { rangeStart, rangeEnd};
  }
  
}
