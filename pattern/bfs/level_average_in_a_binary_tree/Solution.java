package pattern.bfs.level_average_in_a_binary_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import pattern.bfs.TreeNode;

public class Solution {
  public static List<Double> findLevelAverage(TreeNode root) {
    List<Double> result = new ArrayList<>();
    if (root == null) return result;

    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      int levelSize = queue.size();
      double levelSum = 0;
      for (int i = 0; i < levelSize; i++) {
        TreeNode currrentNode = queue.poll();
        levelSum += currrentNode.val;
        if (currrentNode.left != null) queue.offer(currrentNode.left);
        if (currrentNode.right != null) queue.offer(currrentNode.right);
      }
      result.add((double) (levelSum/ levelSize));
    }
    return result;
  }
  
}
