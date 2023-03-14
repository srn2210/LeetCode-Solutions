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
    int dfs(TreeNode node, int sum) {
        //if((node.left == null && node.right != null) || (node.left != null && node.right == null)) return 0;
        if(node.left == null && node.right == null) return (sum * 10) + node.val;
        sum *= 10;
        sum += node.val;
        int left = 0, right = 0;
        if(node.left != null) left = dfs(node.left, sum);
        if(node.right != null) right = dfs(node.right, sum);
        return left + right;
    }
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }
}