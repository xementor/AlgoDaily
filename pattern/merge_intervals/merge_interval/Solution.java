package pattern.merge_intervals.merge_interval;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import pattern.merge_intervals.Interval;

public class Solution {
    public static List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() < 2) return intervals;
        
        // sort the interval by start time
        Collections.sort(intervals, (a,b) -> Integer.compare(a.start, b.start));

        List<Interval> mergedIntervals = new LinkedList<Interval>();
        Iterator<Interval> intervalItr = intervals.iterator();
        Interval interval = intervalItr.next();

        int start = interval.start;
        int end = interval.end;

        /*
         * [1,4] [2,5] [3,4] [7,9]
         */
        while (intervalItr.hasNext()) {
            interval = intervalItr.next();
            if (interval.start <= end) end = Math.max(interval.end, end);
            else {
                mergedIntervals.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }
        }

        mergedIntervals.add(new Interval(start, end));

        return mergedIntervals;
    }

    public static List<Interval> merge2(List<Interval> intervals) {
        if (intervals.size() < 2) return intervals;
        Collections.sort(intervals, (a,b) -> Integer.compare(a.start, b.start));

        var mergedIntervals = new LinkedList<Interval>();
        var intervalItr = intervals.iterator();
        var interval = intervalItr.next();
        int start = interval.start;
        int end = interval.end;

        while (intervalItr.hasNext()) {
            interval = intervalItr.next();
            if (interval.start <= end) end = Math.max(interval.end, end);
            else {
                mergedIntervals.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }
        }
        mergedIntervals.add(new Interval(start, end));

        return mergedIntervals;

    }
}
