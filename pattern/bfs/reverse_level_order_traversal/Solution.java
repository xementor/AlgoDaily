package pattern.bfs.reverse_level_order_traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import pattern.bfs.TreeNode;


public class Solution {
  public static List<List<Integer>> reverse_traverse(TreeNode root){
    List<List<Integer>> result = new LinkedList<List<Integer>>();
    // check null
    if (root == null) return result;
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);

    while (!queue.isEmpty()) {
      int levelSize = queue.size();
      List<Integer> currenLevel = new ArrayList<Integer>(levelSize);
      for (int i = 0; i < levelSize; i++) {
        var currentNode = queue.poll();
        currenLevel.add(currentNode.val);
        if (currentNode.left != null) queue.offer(currentNode.left);
        if (currentNode.right != null) queue.offer(currentNode.right);
      }
      result.add(0, currenLevel);
    }
    return result;
  }
  
}
