package contest;

import java.util.PriorityQueue;

class Node {
    int idx;
    int row;
    
    Node(int idx, int row) {
        this.idx = idx;
        this.row = row;
    }
}



class Solution {
    public int[][] sortTheStudents(int[][] score, int k) {
      PriorityQueue<Node> maxHeap = new PriorityQueue<>((n1,n2) -> score[n2.row][n2.idx] - score[n1.row][n1.idx]);
      int rows = score.length;
      for (int r=0; r < rows; r++)
        maxHeap.add(new Node(k, r));
      
      int[][] result = new int[rows][score[0].length];
      int kk = 0;
      while (!maxHeap.isEmpty()) {
        var curNode = maxHeap.poll();
        int row = curNode.row;
        result[kk] = score[row];
        kk++;
      }
        
        
      return result;
    }
}