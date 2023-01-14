package pattern.dfs.binary_tree_path_sum;

import pattern.bfs.TreeNode;

class Solution {
   public static boolean hasPath(TreeNode root, int sum) {
    if (root == null) return false;

    if (root.val == sum && root.left == null && root.right == null) return true;
    return hasPath(root.left, sum - root.val) or hasPath(root.right, sum - root.val);
   }

}