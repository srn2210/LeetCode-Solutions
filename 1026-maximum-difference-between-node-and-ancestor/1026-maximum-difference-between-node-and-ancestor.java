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
    int dfs(TreeNode node, int min, int max) {
        if(node == null) return Math.abs(max - min);
        min = Math.min(min, node.val);
        max = Math.max(max, node.val);
        return Math.max(dfs(node.left, min, max), dfs(node.right, min, max));
    }
    public int maxAncestorDiff(TreeNode root) {
        return dfs(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }
}