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
    int max = Integer.MIN_VALUE;
    int dfs(TreeNode node) {
        if(node == null) return 0;
        int curr = node.val;
        int left = dfs(node.left);
        int right = dfs(node.right);
        int locmax = Math.max(left + curr, curr);
        locmax = Math.max(right + curr, locmax);
        max = Math.max(max, locmax);
        max = Math.max(max, left + curr + right);
        return locmax;
    }
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return max;
    }
}