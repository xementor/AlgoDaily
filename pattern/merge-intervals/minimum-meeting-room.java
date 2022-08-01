import java.util.Collections;
import java.util.PriorityQueue;

class MinimumMeetingRooms{
    int findMinimumMeetingRooms(List<Meeting> meetings){
        if(meetings == null || meetings.size() == 0){
            return 0;
        }

        // sort the meeting by start time
        Collections.sort(meetings, (a,b) -> Integer.compare(a.start, b.start));;

        int minRoom = 0;
        PriorityQueue<Meeting> minHeap = 
            new PriorityQueue<>(meetings.size(), (a,b) -> Integer.compare(a.end, b.end));
        for ( Meeting meeting : meetings ){
            // remove all meeting that have ended
            while (!minHeap.isEmpty() && meetings.start >= minHeap.peek().end){
                minHeap.poll();
                // add the current meeting into the heap
                minHeap.offer(meeting);
                minRooms = Math.min(minRoom, minHeap.size());
            }
        }
        return minRoom;
    }
}