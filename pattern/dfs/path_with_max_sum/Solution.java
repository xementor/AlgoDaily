package pattern.dfs.path_with_max_sum;

import pattern.bfs.TreeNode;

public class Solution {
  private static int globalMaximum;

  public static int findMaximumPathSum(TreeNode root) {
    globalMaximum = Integer.MIN_VALUE;
    findSumRecursive(root);
    return globalMaximum;
  }

  private static int findSumRecursive(TreeNode currentNode) {
    if (currentNode == null) return 0;

    int leftSum = findSumRecursive(currentNode.left);
    int rightSum = findSumRecursive(currentNode.right);

    leftSum = Math.max(leftSum,0);
    rightSum = Math.max(rightSum,0);

    int localMaximumSum = leftSum + rightSum + currentNode.val;
    globalMaximum = Math.max(globalMaximum,localMaximumSum);

    return Math.max(leftSum,rightSum)+currentNode.val;
  }
  
}
