package pattern.bfs.zigzag_traversal;

import java.security.interfaces.RSAKey;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import pattern.bfs.TreeNode;

public class Solution {
  public static List<List<Integer>> zigzag_traversal(TreeNode root) {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    if (root == null) return result;

    Queue<TreeNode> queue = new LinkedList<TreeNode>();
    queue.offer(root);
    boolean zagDirection = true;

    while (!queue.isEmpty()) {
      int levelSize = queue.size();
      List<Integer> currenLevel = new  ArrayList<Integer>(levelSize);

      for (int i=0; i < levelSize; i++) {
        var currentNode = queue.poll();
        // add the node base on traversal rule
        if (zagDirection) currenLevel.add(currentNode.val);
        else currenLevel.add(0, currentNode.val);

        if (currentNode.left != null) queue.offer(root.left);
        if (currentNode.right != null) queue.offer(root.right);
      }
      result.add(currenLevel);
      zagDirection = !zagDirection;

    }

    return result;
  }
  
}
