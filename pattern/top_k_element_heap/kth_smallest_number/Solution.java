package pattern.top_k_element_heap.kth_smallest_number;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Solution {
  public static int findKthSmallestNumber(int[] nums, int k) {
    PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(
      (n1, n2) -> n2 - n1
    );
    for (int i = 0; i < k; i++) maxHeap.add(nums[i]);
    for (int i = k; i < nums.length; i++) {
      if (nums[i] < maxHeap.peek()) {
        maxHeap.poll();
        maxHeap.add(nums[i]);
      }
    }
    return maxHeap.peek();
  }
  
}
