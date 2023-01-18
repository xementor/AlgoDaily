package merge;

import java.util.PriorityQueue;

import pattern.ListNode;

public class Solution {
  public static ListNode merge(ListNode[] lists) {
    PriorityQueue<ListNode> minHeap = 
      new PriorityQueue<>((n1,n2)-> n1.value - n2.value);

    for (ListNode root: lists) {
      if (root != null) {
        minHeap.add(root);
      }
    }

    ListNode resultHead = null, resultTail = null;
    while (!minHeap.isEmpty()) {
      var node = minHeap.poll();
      if (resultHead == null) {
        resultHead = resultTail = node;
      } else {
        resultTail.next = node;
        resultTail = resultTail.next;
      }

      if (node.next != null)
        minHeap.add(node.next);
    }
    return resultHead;
  }
  
}
