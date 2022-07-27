class Solution {
    TreeNode ans = new TreeNode();
    boolean dfs(TreeNode node, TreeNode p, TreeNode q) {
        if(node == null) return false;
        
        boolean left = dfs(node.left, p, q);
        boolean right = dfs(node.right, p, q);
        
        boolean mid = (node == p || node == q);
        
        if(mid && left || mid && right || left && right) {
            this.ans = node;
        }
        
        return mid || left || right;
        
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {        
        dfs(root, p, q);
        
        return this.ans;
        
    }
}