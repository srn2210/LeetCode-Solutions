class Solution {
    void dfs(TreeNode node) {
        if(node == null) return;
        
        dfs(node.left);
        dfs(node.right);
        
        TreeNode temp = node.left;
        
        node.left = node.right;
        node.right = temp;
    }
    public TreeNode invertTree(TreeNode root) {        
        dfs(root);
        
        return root;
    }
}