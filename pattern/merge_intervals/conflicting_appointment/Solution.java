package pattern.merge_intervals.conflicting_appointment;

import pattern.merge_intervals.Interval;

public class Solution {
  public static boolean canAttendAllAppointments(Interval[] intervals) {
    
    /*
     * [6,7] [2,4] [8,12]
     * [2,4] [6,7]  [8,12]
     */
    for (int i=1; i<intervals.length; i++) 
      if (intervals[i].start < intervals[i-1].end) return false;
    return true;
  }
}
