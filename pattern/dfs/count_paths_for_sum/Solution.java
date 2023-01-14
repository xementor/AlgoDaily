package pattern.dfs.count_paths_for_sum;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import pattern.bfs.TreeNode;


public class Solution {
  public static int count_paths_for_sum(TreeNode root, int sum){
    List<Integer> currentPath = new ArrayList<>();
    return countPathRecursive(root,sum,currentPath);
  }

  private static int countPathRecursive(TreeNode currentNode, int sum, List<Integer> currentPath) {
    if (currentNode == null) return 0;
    currentPath.add(currentNode.val);
    int pathCount = 0, pathSum = 0;
    ListIterator<Integer> pathIterator = currentPath.listIterator(currentPath.size()-1);
    while(pathIterator.hasPrevious()) {
      pathSum += pathIterator.previous();
      if (pathSum == sum) pathCount++;
    }

    pathCount += countPathRecursive(currentNode.left, pathSum, currentPath);
    pathCount += countPathRecursive(currentNode.right, pathSum, currentPath);
    return pathCount;
  }

}
