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
    long ans = 0;
    long total = 0;
    long dfs(TreeNode node) {
        if(node == null) return 0;
        long sum = dfs(node.left) + node.val + dfs(node.right);
        ans = Math.max(ans, sum * (total - sum));
        return sum;
    }
    public int maxProduct(TreeNode root) {
        total = dfs(root);
        dfs(root);
        return (int) (ans % 1000000007);
    }
}