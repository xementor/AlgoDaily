package pattern.top_k_element_heap.top_k_frequent_numbers;

import java.time.chrono.MinguoEra;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution {
  public static List<Integer> findTopKFrequentNumbers(int[] nums, int k) {
    List<Integer> topNumbers = new ArrayList<>(k);
    // first have to build a map of frequencey
    Map<Integer,Integer> numFreqMap = new HashMap<>(); 
    for (int n: nums)
      numFreqMap.put(n, numFreqMap.getOrDefault(n, 0)+1);
    PriorityQueue<Map.Entry<Integer, Integer>> minHeap = 
      new PriorityQueue<>((e1,e2) -> e1.getValue() - e2.getValue());
    
    for (Map.Entry<Integer, Integer> entry: numFreqMap.entrySet()) {
      minHeap.add(entry);
      if (minHeap.size() > k) minHeap.poll();
    }

    while (!minHeap.isEmpty()) topNumbers.add(minHeap.poll().getKey());

    return topNumbers;
  }
}
