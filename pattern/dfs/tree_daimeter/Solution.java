package pattern.dfs.tree_daimeter;

import pattern.bfs.TreeNode;

public class Solution {
  private static int treeDiameter = 0;
  public static int findDiameter(TreeNode root) {
    calculateHeigh(root);
    return treeDiameter;
  }
  private static int calculateHeigh(TreeNode currentNode) {
    if (currentNode == null) return 0;

    int leftTreeHeight = calculateHeigh(currentNode.left);
    int rightTreeHight = calculateHeigh(currentNode.right);

    int diameter = leftTreeHeight + rightTreeHight + 1;
    treeDiameter = Math.max(treeDiameter, diameter);

    return Math.max(leftTreeHeight, rightTreeHight) + 1;
  }
  
}
