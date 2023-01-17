package pattern.top_k_element_heap.frequency_sort;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Sort {
  public static String sortCharecterByFrequencY(String str) {
    Map<Character,Integer> charFreqmap = new HashMap<>();
    for (char chr : str.toCharArray()) {
      charFreqmap.put(
        chr,
        charFreqmap.getOrDefault(chr, 0)+1
      );
    }

    PriorityQueue<Map.Entry<Character,Integer>> maxHeap = 
      new PriorityQueue<>((e1,e2) -> e2.getValue() - e1.getValue()); 
    
    // Add all character to max heap
    maxHeap.addAll(charFreqmap.entrySet());

    // build a string, appending the most occuring charecter first
    StringBuilder sortedString = new StringBuilder(str.length());
    while (!maxHeap.isEmpty()) {
      Map.Entry<Character, Integer> entry = maxHeap.poll();
      for (int i=0; i < entry.getValue(); i++)
        sortedString.append(entry.getKey());
    }

    return sortedString.toString();
  }
}
