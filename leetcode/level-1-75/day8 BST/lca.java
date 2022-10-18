class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode n1, TreeNode n2) {
        if (root==null) return null;
 
        if (root==n1 || root==n2) return root;
 
        TreeNode leftLCA = lowestCommonAncestor(root.left, n1, n2);
        TreeNode rightLCA = lowestCommonAncestor(root.right, n1, n2);
 
        if (leftLCA != null && rightLCA != null) return root
        if (leftLCA != null) return leftLCA;
        
        return rightLCA;   
    }
}