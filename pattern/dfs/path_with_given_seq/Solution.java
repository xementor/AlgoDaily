package pattern.dfs.path_with_given_seq;

import pattern.bfs.TreeNode;

public class Solution {
  public static boolean path_with_given_seq(TreeNode root, int[] sequence){
    if (root == null)
      return sequence.length == 0;

    return findPathRecursive(root, sequence, 0);
  }

  private static boolean findPathRecursive(TreeNode currentNode, int[] sequence, int idx) {
    if (currentNode == null)  return false;
    if (idx >= sequence.length || currentNode.val != sequence[idx])
      return false;
    
      if (currentNode.left == null && currentNode.right == null
          && idx == sequence.length -1 )
          return true;

    return findPathRecursive(currentNode.left, sequence, idx+1) ||
            findPathRecursive(currentNode.right, sequence, idx+1);

  }


  
}