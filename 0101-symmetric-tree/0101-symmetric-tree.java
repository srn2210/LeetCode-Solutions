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
    boolean dfs(TreeNode n1, TreeNode n2) {
        if(n1 == null && n2 == null) return true;
        if(n1 == null && n2 != null || n1 != null && n2 == null) return false;
        if(n1.val != n2.val) return false;
        return dfs(n1.left, n2.right) && dfs(n2.left, n1.right);
    }
    public boolean isSymmetric(TreeNode root) {
        return dfs(root.left, root.right);
    }
}