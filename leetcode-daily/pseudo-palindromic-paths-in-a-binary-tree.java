/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
 class Solution {
    public int pseudoPalindromicPaths (TreeNode root) {
        int count = 0, path = 0; 
        
        // Pair<Node, currentPath> 
        Stack<Pair<TreeNode, Integer>> stack = new Stack<>();
        stack.push(new Pair<>(root, 0));
        
        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> cur = stack.pop();
            TreeNode node = cur.getKey();
            path = cur.getValue();
            
            if (node != null) {
                path ^= (1 << node.val);
                
                if (node.left == null && node.right == null) {
                    // leaf node
                    if ((path & (path - 1)) == 0) {
                        count++;
                    }
                } else {
                    stack.push(new Pair<>(node.left, path));
                    stack.push(new Pair<>(node.right, path));
                }
            }
        }
        
        return count;
    }
}
class Solution {
    public int pseudoPalindromicPaths (TreeNode root) {
        int[] count= new int[]{0};
        rec(root, new int[10], count);
        return count[0];
    }
    void rec(TreeNode node, int[]f, int[] count){
        f[node.val]++;
        if(node.left==null && node.right==null){
            if(isPal(f)){
                count[0]++;
            }
            f[node.val]--;
            return;
        }
        if(node.left!=null)
            rec(node.left, f, count);
        if(node.right!=null)
            rec(node.right, f, count);
        f[node.val]--;
    }
    boolean isPal(int[]f){
        int odds=0;
        for(int i=1; i<10; i++){
            if(f[i]%2!=0)
                odds++;
            if(odds>1)
                return false;
        }
        return true;
    }
}