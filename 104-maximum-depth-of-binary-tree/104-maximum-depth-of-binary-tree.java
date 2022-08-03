class Solution {
    int dfs(TreeNode node) {
        if(node == null) return 0;
        
        int left = dfs(node.left);
        int right = dfs(node.right);
        
        return Math.max(left, right) + 1;
    }
    public int maxDepth(TreeNode root) {
        return dfs(root);
    }
}