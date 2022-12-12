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
    boolean find(TreeNode root, TreeNode node, int target) {
        if(root == null) return false;
        if(root.val < target) return find(root.right, node, target);
        if(root.val > target) return find(root.left, node, target);
        if(root == node) return false;
        if(root.val == target) return true;
        return false;
    }
    boolean dfs(TreeNode root, TreeNode node, int target) {
        if(node == null) return false;
        if(find(root, node, target - node.val)) return true;
        if(dfs(root, node.left, target)) return true;
        if(dfs(root, node.right, target)) return true;
        return false;
    }
    public boolean findTarget(TreeNode root, int k) {
        return dfs(root, root, k);
    }
}