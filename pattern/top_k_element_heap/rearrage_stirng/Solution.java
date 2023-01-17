package pattern.top_k_element_heap.rearrage_stirng;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution {
  public static String rearrageString(String str) {
    Map<Character,Integer> charFreq = new HashMap<>();
    for (char chr: str.toCharArray())
      charFreq.put(chr, charFreq.getOrDefault(chr, 0)+1);

    PriorityQueue<Map.Entry<Character, Integer>> maxHeap = 
      new PriorityQueue<>((e1,e2) -> e2.getValue() - e1.getValue());
    maxHeap.addAll(charFreq.entrySet());

    Map.Entry<Character,Integer> previousEntry = null;
    StringBuilder resultString = new StringBuilder(str.length());
    while (!maxHeap.isEmpty()) {
      var currentEntry = maxHeap.poll();
      if (previousEntry != null && previousEntry.getValue() > 0)
        maxHeap.offer(previousEntry);
      
      resultString.append(currentEntry.getValue());
      currentEntry.setValue(currentEntry.getValue()-1);
      previousEntry = currentEntry;
    }

    return "";
  }
  
}
