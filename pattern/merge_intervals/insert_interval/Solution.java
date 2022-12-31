package pattern.merge_intervals.insert_interval;

import java.util.ArrayList;
import java.util.List;
import pattern.merge_intervals.Interval;

public class Solution {
    public static List<Interval> insertInterval(List<Interval> intervals, Interval newInterval) {
        var mergedIntervals = new ArrayList<Interval>();

        // Insert in correct place
        int idx = 0;


        // directly add intervals that's end time less than new one's start time
        while (
            idx < intervals.size() 
            && intervals.get(idx).end < newInterval.start
        ) {
            mergedIntervals.add(intervals.get(idx));
            idx++;
        }


        /* [1,3] [5,7] [8,12] => [4,6]
        *  [1,3] 
        */
        
        // is any interval overlap there
        while (idx < intervals.size() && 
        intervals.get(idx).start <= newInterval.end) {
            newInterval.start = Math.min(intervals.get(idx).start, newInterval.start);
            newInterval.end = Math.max(intervals.get(idx).end, newInterval.end);
        }

        mergedIntervals.add(newInterval);

        // then add rest of the intervals
        while ( idx < intervals.size()) {
            mergedIntervals.add(intervals.get(idx++));
        }

        return mergedIntervals;
    }

    public static void main(String[] args) {
        var intervals = new ArrayList<Interval>();
        intervals.add(new Interval(1, 3));
        intervals.add(new Interval(5, 7));
        intervals.add(new Interval(8, 12));
        var newI = new Interval(4, 1);
        insertInterval(intervals, newI);
    }
}
