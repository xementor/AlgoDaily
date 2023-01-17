package pattern.top_k_element_heap.top_k_number;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {
  public static List<Integer> findKLargestNumber(int[] nums, int k) {
    PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>((n1,n2) -> n1 - n2);
    for (int i=0; i < k; i++) minHeap.add(nums[i]);
    for (int i = k; i < nums.length; i++) {
      if (nums[i] > minHeap.peek()) {
        minHeap.poll();
        minHeap.add(nums[i]);
      }
    }
    return new ArrayList<>(minHeap);
  }
  
}
