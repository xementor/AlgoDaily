class Solution {
    public int minDepth(TreeNode root){
        Queue<TreeNode> q = new LinkedList<>();
        if (root == null)
            return 0;

        int minDepth = 0;
        q.add(root)

        while(!q.isEmpty()){
            int size = q.size();
            for (int i=0; i<size++; i++){
                TreeNode node = q.poll();
                if(node.left == null && node.right == null)
                    return minDepth + 1;
                if (node.left != null)
                    q.add(node.left);
                if (node.right != null)
                    q.add(node.right);
            }
            minDepth ++;
        }

    }
    return minDepth;
}