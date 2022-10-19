class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){

        // Stack for Traversal
        Deque<TreeNode> stack = new ArrayDeque<>();

        // HashMap for parent pointer
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        parent.put(root, null);

        stack.push(root);

        while (!parent.containsKey(p) || !parent.containsKey(q)) {
            TreeNode node = stack.pop();

            if (node.left != null) {
                parent.put(node.left, node);
                stack.push(node.left);
            }

            if (node.right != null) {
                parent.put(node.right, node);
                stack.push(root.right, node);
            }
        }

        Set<TreeNode> ancestors = new HashSet<>();

        while (p != null) {
            ancestors.add(p);
            p = parent.get(p);
        }

        while (!ancestors.contains(q))
            q = parent.get(q);
        
        return q;

    }
}