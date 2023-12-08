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
    String solve(TreeNode node) {
        if(node == null) return "";
        StringBuilder ans = new StringBuilder();
        ans.append(node.val);
        if(node.left == null && node.right == null) return ans.toString();
        ans.append('(');
        ans.append(solve(node.left));
        ans.append(')');
        if(node.right != null) {
            ans.append('(');
            ans.append(solve(node.right));
            ans.append(')');
        }
        return ans.toString();
    }
    public String tree2str(TreeNode root) {
        return solve(root);
    }
}