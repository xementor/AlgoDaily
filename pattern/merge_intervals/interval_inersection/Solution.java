package pattern.merge_intervals.interval_inersection;

import java.util.ArrayList;
import java.util.List;
import pattern.merge_intervals.Interval;

public class Solution {
  public static Interval[] merge(Interval[] arr1, Interval[] arr2) {
    List<Interval> intervalsIntersection = new ArrayList<Interval>();
    int idx1 = 0, idx2 = 0;

    while (idx1 < arr1.length && idx2 < arr2.length) {
      Interval rightInterval = arr2[idx2];
      Interval leftInterval = arr1[idx1];

      // when two interval intersect
      if (
        rightInterval.start >= leftInterval.start && rightInterval.start <= leftInterval.end 
        ||
        leftInterval.start >= rightInterval.start && leftInterval.start <= rightInterval.end
        
      ) {
        int start = Math.max(rightInterval.start, leftInterval.start);
        int end = Math.min(leftInterval.end, rightInterval.end);
        intervalsIntersection.add(new Interval(start, end));
        idx1 ++;
      }

      // update pointer of loop
      if (
        leftInterval.end < rightInterval.end
      ) idx1 ++;
      else idx2 ++;

    }

    return intervalsIntersection.toArray(
      new Interval[intervalsIntersection.size()]
    );
  }

  public static void main(String[] args) {
    merge(null, null);
  }
  
}
