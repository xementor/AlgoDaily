package pattern.merge_intervals.minimum_meeting_rooms;

import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

import pattern.merge_intervals.Interval;

public class Solution {
  /**
   * @param meetings
   * @return int
   *         [[1,4], [2,3], [3,6]]
   *         [4,5], [2,3], [2,4], [3,5]
   * @hidden [2,3] [2,4] [3,5] [4,5]
   *          [2,4] [3,5] [4,5]
   * 
   * Loop though all the list of meeting
   * for each meeting
   *          
   */
  public static int findMinimumMeetingRooms(List<Interval> meetings) {
    if (meetings.size() == 0) return 0;

    Collections.sort(meetings, (a,b) -> Integer.compare(a.start, b.start));

    int minRooms = 0;
    PriorityQueue<Interval> minHeap = 
      new PriorityQueue<>(
        meetings.size(),
        (a,b) -> Integer.compare(a.end, b.end)
      );
    
    for (var meeting : meetings) {
      // remove all meeting that have ended
      while (!minHeap.isEmpty() && meeting.start >= minHeap.peek().end)
        minHeap.poll();

      // add the current meeting into heap
      minHeap.offer(meeting);

      minRooms = Math.max(minRooms, minHeap.size());
    }

    return minRooms;
  }
  
}
