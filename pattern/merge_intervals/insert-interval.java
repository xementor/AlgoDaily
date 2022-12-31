class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> merged = new ArrayList<>();
        
        int i = 0;
        // System.out.println(intervals[i][1]);
        
        // skip all the interval whose end value less than newInterval's start
        while(i < intervals.length && intervals[i][1] < newInterval[0]){
            merged.add(intervals[i++]);
        }
        
        // insert newInterval
        while( i < intervals.length && intervals[i][0] <= newInterval[1]){
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }
        merged.add(newInterval);
        
        // add rest of the interval into answer.
        while( i< intervals.length )
            merged.add(intervals[i++]);
        
    
        return merged.toArray(new int[merged.size()][]);
        
    }
}