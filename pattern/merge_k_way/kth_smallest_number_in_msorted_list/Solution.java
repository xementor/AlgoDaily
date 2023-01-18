package kth_smallest_number_in_msorted_list;

import java.util.List;
import java.util.PriorityQueue;

class Node {
  int elIdx; // element Index
  int arrIdx; // arr Index

  Node(int elIdx, int arrIdx) {
    this.elIdx = elIdx;
    this.arrIdx = arrIdx;
  }
}

public class Solution {
  public static int findKthSmallest(List<Integer[]> lists, int k) {
    PriorityQueue<Node> minHeap = 
      new PriorityQueue<>(
        (n1,n2) -> lists.get(n1.arrIdx)[n1.elIdx] - lists.get(n2.arrIdx)[n2.elIdx]);
    
    // Add first element to the minHeap
    for (int i=0; i < lists.size(); i++)
      minHeap.add(new Node(0,i));
    
    int numberCount = 0, result = 0;
    while (!minHeap.isEmpty()) {
      var node = minHeap.poll();
      result = lists.get(node.arrIdx)[node.elIdx];
      if (++numberCount == k) break;
      node.elIdx++;
      if (lists.get(node.arrIdx).length > node.elIdx)
        minHeap.add(node);
    }
    
    return result;
  }
  
}

/*
 * [2, 6, 8]          1
 * [3, 6, 7]         2  3
 * [1, 3, 4]
 */