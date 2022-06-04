/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * 
 * Aproach should be think as ancestor always in upper side.
 */

public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root.val > p.val && root.val > q.val){
            return lowestCommonAncestor(root.left, p, q);
        }else if(root.val < p.val && root.val < q.val){
            return lowestCommonAncestor(root.right, p, q);
        }else{
            return root;
        }
    }
}
//     TreeNode search(TreeNode root, TreeNode p, TreeNode q){
//         if(root == null){
//             return null;
//         }
//         if(root.val == q.val){
//             return root;
//         }
       
//         if(root.val == p.val){
//             if(root.left != null){
//                 if(root.left.val == q.val){
//                     return root;
//                 }
                
//             }
//             if(root.right != null){
//                 if(root.right != null){
//                     if(root.right.val == q.val){
//                         return root;
//                     }
//                 }
//             }
//         }
//         if (root.left.val == p.val && root.right.val == q.val){
//             return root;
//         }
        
//         if(root.val > p.val){
//             TreeNode low =  search(root.left, p, q);
//         } else {
//             return search(root.right, p, q);
//         }
//     }
// }