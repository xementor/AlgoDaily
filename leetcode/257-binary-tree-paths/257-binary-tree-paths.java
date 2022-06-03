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
    List<String> result = new ArrayList<String>();
    List<Integer> numbers = new ArrayList<Integer>();
    
    public List<String> binaryTreePaths(TreeNode root) {
        inorder(root);
        return result;
    }
    
    void inorder(TreeNode root){
        if ( root == null ) return;

        numbers.add(root.val);
        
        if(root.left == null && root.right == null){
            String str = "";
            for (int i = 0; i< numbers.size(); i++){
                if(i == numbers.size() -1){
                    str += Integer.toString(numbers.get(i));
                } else{
                str += Integer.toString(numbers.get(i)) + "->"; 
                }
                
            }
            result.add(str);
           
        }
        
        
        inorder(root.left);
        
        inorder(root.right);
        numbers.remove(numbers.size()-1);
        
    }
}