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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null)
            return result;
        
        Queue<TreeNode> queue = new LinkedList<>();
        
        // give first note in the queue.
        queue.offer(root);
    
        while (!queue.isEmpty()){
            // after second iteration in the quest 2nd level elements will the there.
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<Integer>(levelSize);
            
            for (int i=0; i<levelSize; i++){
                TreeNode curr = queue.poll();  // main goal to pull all the item in this level.
                currentLevel.add(curr.val);    // add this value to the currentLevel
                                                
                if(curr.left != null)          // while polling a treenode, its  left and right node
                    queue.offer(curr.left);    // will be added to the queue. that mean curr
                                               // nodes next level element are getting added to the queue.
                if(curr.right != null)
                    queue.offer(curr.right);
                
            }
            result.add(currentLevel);           // after one iteration currente level nodes are popped out
                                                // and added to the result and next level are in the quest
        }                                       // ready to go for a next iteration
        return result;
        
    }
}