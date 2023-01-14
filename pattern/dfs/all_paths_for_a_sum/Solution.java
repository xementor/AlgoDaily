package pattern.dfs.all_paths_for_a_sum;

import java.util.ArrayList;
import java.util.List;

import pattern.bfs.TreeNode;

public class Solution {
  public static List<List<Integer>> findPath(TreeNode root, int sum) {
    List<List<Integer>> allPaths = new ArrayList<>();
    List<Integer> currentPath = new ArrayList<>();
    findPathRecursive(root, sum, currentPath, allPaths);
    return allPaths;
  }

  private static void findPathRecursive(TreeNode currentNode, int sum, List<Integer> currentPath,
      List<List<Integer>> allPaths) {
    if (currentNode == null) return;

    // add the currentNode to the path
    currentPath.add(currentNode.val);

    // if the current node is leaf and equal to sum, save to it to resualt
    if (currentNode.val == sum && currentNode.left == null &&
        currentNode.right == null) {
      allPaths.add(currentPath);
    }

    else {
      findPathRecursive(currentNode.left, sum - currentNode.val, currentPath, allPaths);
      findPathRecursive(currentNode.right, sum - currentNode.val, currentPath, allPaths);
    }

    currentPath.remove(currentPath.size()-1);
  }
  
}
