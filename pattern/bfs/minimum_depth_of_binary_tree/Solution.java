package pattern.bfs.minimum_depth_of_binary_tree;

import java.util.LinkedList;
import java.util.Queue;

import pattern.bfs.TreeNode;


public class Solution {
  public static int minimum_depth_of_binary_tree(TreeNode root) {
    if (root == null) return 0;
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);

    int minDepth = 0;
    while (!queue.isEmpty()) {
      int levelSize = queue.size();
      minDepth ++;

      for (int i = 0; i < levelSize; i++) {
        TreeNode currentNode = queue.poll();

        if (currentNode.left == null && currentNode.right == null)
          return minDepth;
        if (currentNode.left != null) queue.offer(currentNode.left);
        if (currentNode.right != null) queue.offer(currentNode.right);
      }
    }
    return minDepth;
  }
}
