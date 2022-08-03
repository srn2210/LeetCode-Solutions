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
    int count = 0;
    int diameter(TreeNode node) {
        if(node == null) return 0;
        
        int left = 0;
        int right = 0;
        
        left = diameter(node.left);
        right = diameter(node.right);
        
        count = Math.max(count, left + right);
        
        
        return Math.max(left, right) + 1;
        
    }
    public int diameterOfBinaryTree(TreeNode root) {
        diameter(root);
        return count;
    }
}