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
/*
    Aproach 1: Inorder recursion
    - go depth of left
    - then go right
*/
class Solution2 {
    List<Integer> result = new ArrayList<Integer>();
    public List<Integer> inorderTraversal(TreeNode root) {
        traverse(root);
        return result;
        
    }
    
    void traverse(TreeNode root){
        if(root != null){
            inorderTraversal(root.left);
            result.add(root.val);
            inorderTraversal(root.right);  
        }
        
    }
}

/**
    Aproach 2: DFS with iteration ( while loop )
    - make a Deque Stack.
    -2 add all the left element in stack
    - remove one , add this in result -> go its right
    - then repeat from 2
    - 
*/
class Solution{
    
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        TreeNode head = root;
        
        while (!stack.isEmpty() || head != null){
            while (head != null){
                stack.add(head);
                head = head.left;
            }
            head = stack.removeLast();
            result.add(head.val);
            head = head.right;
        }
        return result;
    }
    
}