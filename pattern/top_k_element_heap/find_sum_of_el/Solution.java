package pattern.top_k_element_heap.find_sum_of_el;

import java.util.PriorityQueue;

public class Solution {
  public static int findSumOfElement(int nums[], int k1, int k2) {
    PriorityQueue<Integer> minHeap =
      new PriorityQueue<>((n1,n2) -> n1 - n2);
    for (int i = 0; i < nums.length; i++) {
      minHeap.add(nums[i]);
    }

    for (int i=0; i< k1; i++) {
      minHeap.poll();
    }

    int elementSum = 0;
    for (int i=0; i < k2 - k1 - 1; i++) {
      elementSum += minHeap.poll();
    }

    return elementSum;
  }
  
}
