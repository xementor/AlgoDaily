package pattern.top_k_element_heap.k_closest_points_to_origin;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Point {
  int x;
  int y;
  Point(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public int distFromOrigin() {
    return (x*x) + (y*y);
  }
}

public class Solution {
  public static List<Point> findClosestPoints(Point[] points, int k) {
    PriorityQueue<Point> maxHeap = 
      new PriorityQueue<Point>((n1,n2) -> (n2.distFromOrigin() - n1.distFromOrigin()));
    for (int i=0; i < k; i++) maxHeap.add(points[i]);
    for (int i = k; i < points.length; i++) {
      if (points[i].distFromOrigin() < maxHeap.peek().distFromOrigin()) {
        maxHeap.poll();
        maxHeap.add(points[i]);
      }
    }
    return new ArrayList<>(maxHeap);
  }
  
}
