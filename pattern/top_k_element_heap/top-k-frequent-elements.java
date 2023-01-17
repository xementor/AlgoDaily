class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> numbersFrequencey = new HashMap<Integer, Integer>();
        
        
        for (int num: nums)
            numbersFrequencey.put(num, numbersFrequencey.getOrDefault(num,0)+1);
        
        
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = 
            new PriorityQueue<Map.Entry<Integer,  Integer>>((e1,e2) -> e1.getValue() - e2.getValue());
        
        for (Map.Entry<Integer,Integer> entry: numbersFrequencey.entrySet()){
            minHeap.add(entry);
            if(minHeap.size() > k){
                minHeap.poll();
            }
        }
    
        int[] topNumbers = new int[k];
        
        int idx = 0;
        while(!minHeap.isEmpty()){
            topNumbers[idx] = minHeap.poll().getKey();
        }
        return topNumbers;
        
        
        
    }
}
