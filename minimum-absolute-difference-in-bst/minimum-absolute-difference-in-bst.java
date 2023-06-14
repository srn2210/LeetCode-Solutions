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
    int dfs(TreeNode node, int leftBound, int rightBound) {
        if(node == null) return Integer.MAX_VALUE;
        int ans = Math.min(Math.abs(node.val - leftBound), Math.abs(rightBound - node.val));
        ans = Math.min(ans, dfs(node.left, leftBound, node.val));
        ans = Math.min(ans, dfs(node.right, node.val, rightBound));
        //System.out.println(ans + " -- " + node.val);
        return ans;
    }
    public int getMinimumDifference(TreeNode root) {
        return dfs(root, -100000000, 100000000);
    }
}