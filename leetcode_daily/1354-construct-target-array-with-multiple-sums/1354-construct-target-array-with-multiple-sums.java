class Solution {
    public boolean isPossible(int[] target) {
        if (target.length == 1) return target[0] == 1;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        
        int sum = 0;
        for(int n : target){
            pq.add(n);
            sum += n;
        }
        
        while(pq.peek() != 1){
            int curr = pq.poll();
            if( sum - curr == 1) return true;
            
            int x = curr % (sum - curr);
            sum = sum - curr + x;
            
            if (x == 0 || x == curr) return false;
            else pq.add(x);
        }
        
        return true;
        
    }
}