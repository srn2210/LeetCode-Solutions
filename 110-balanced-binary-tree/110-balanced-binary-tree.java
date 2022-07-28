class Solution {
    boolean ans = true;
    int dfs(TreeNode node) {
        if(node == null) return 0;
        int left = 0;
        int right = 0;
        
        left += dfs(node.left);
        right += dfs(node.right);
        
        if(Math.abs(left - right) > 1) ans = false;
        if(left == 0 && right == 0) return 1;
        return left > right ? left+1 : right+1;
    }
    public boolean isBalanced(TreeNode root) {
        dfs(root);
        return ans;
    }
}