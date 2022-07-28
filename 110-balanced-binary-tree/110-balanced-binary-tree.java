class Solution {
    boolean ans = true;
    int dfs(TreeNode node) {
        if(node == null) return 0;
        if(ans == false) return 0;
        int left = 0;
        int right = 0;
        
        left += dfs(node.left);
        right += dfs(node.right);
        
        if(Math.abs(left - right) > 1) ans = false;
        return left > right ? left+1 : right+1;
    }
    public boolean isBalanced(TreeNode root) {
        dfs(root);
        return ans;
    }
}