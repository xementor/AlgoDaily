package pattern.dfs.sum_of_path_numbers;

import java.util.ArrayList;
import java.util.List;

import pattern.bfs.TreeNode;

public class Solution {
  public static int findSumOfPathNumbers(TreeNode root) {
    List<Integer> allNumber = new ArrayList<>();
    int  currentPathDigit = 0; 
    findSumRecursively(root,currentPathDigit,allNumber);
    for(int num: allNumber)
    System.out.println(num);
    return -1;
  }

  private static void findSumRecursively(TreeNode currentNode, 
      int currentPathNumber, 
      List<Integer> allNumber) {

    if (currentNode == null) return;
    
    // add currentNode to currentPathDigit
    currentPathNumber = (currentPathNumber*10) + currentNode.val;

    // when we are in leaf node, its time to find the number of current path
    if(currentNode.left == null && currentNode.right == null) {
      allNumber.add(currentPathNumber);
    }
    else {
      findSumRecursively(currentNode.left, currentPathNumber, allNumber);
      findSumRecursively(currentNode.right, currentPathNumber, allNumber);
    }

    currentPathNumber = (currentPathNumber - currentNode.val) / 10;
  }


  public static int findSumOfPathNumbers2(TreeNode root){
    return findRootToLeafPathNumbers(root,0);
  }

  private static int findRootToLeafPathNumbers(TreeNode currentNode, int pathSum) {
    if (currentNode == null) return 0;
    pathSum = 10 * pathSum + currentNode.val;

    if (currentNode.left == null && currentNode.right == null){
      return pathSum;
    }

    return findRootToLeafPathNumbers(currentNode.left, pathSum) + 
            findRootToLeafPathNumbers(currentNode.right, pathSum);
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(0);
    root.right = new TreeNode(1);
    root.left.left = new TreeNode(1);
    root.right.left = new TreeNode(6);
    root.right.right = new TreeNode(5);
    findSumOfPathNumbers(root);
  }
}
