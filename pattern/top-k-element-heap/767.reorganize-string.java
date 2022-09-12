/*
 * @lc app=leetcode id=767 lang=java
 *
 * [767] Reorganize String
 */

// @lc code=start
class Solution {
    public String reorganizeString(String s) {
        Map<Character, Integer> freq = new HashMap<>();

        for(char ch: s.toCharArray())
            freq.put(ch, freq.getOrDefault(ch,0)+1);

        PriorityQueue<Map.Entry<Character,Integer>> maxHeap =  new PriorityQueue<Map.Entry<Character, Integer>>((e1,e2) -> e2.getValue() - e1.getValue());

        maxHeap.addAll(freq.entrySet());

        Map.Entry<Character,Integer> previous = null;

        StringBuilder resultString = new StringBuilder(s.length());

        while(!maxHeap.isEmpty()){
            Map.Entry<Character, Integer> current = maxHeap.poll();

            if(previous != null && previous.getValue() > 0)
                maxHeap.offer(previous);

            resultString.append(current.getKey());
            current.setValue(current.getValue() -1 );
            previous = current;
        }

        return resultString.length() == s.length() ? resultString.toString() : "";


        
    }
}
// @lc code=end

