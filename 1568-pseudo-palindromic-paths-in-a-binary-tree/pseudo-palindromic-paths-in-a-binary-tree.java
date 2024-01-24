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
    int solve(TreeNode node, int mask) {
        if(node == null) return 0;
        int val = node.val;
        mask ^= (1 << val);
        int ans = solve(node.left, mask) + solve(node.right, mask);
        if(node.left == null && node.right == null) ans += Integer.bitCount(mask) <= 1 ? 1 : 0;
        return ans;
    }
    public int pseudoPalindromicPaths (TreeNode root) {
        return solve(root, 0);
    }
}