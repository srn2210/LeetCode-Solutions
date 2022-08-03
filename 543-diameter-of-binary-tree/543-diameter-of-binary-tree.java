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
        
        left = 1 + diameter(node.left);
        right = 1 + diameter(node.right);
        
        //System
        
        count = Math.max(count, left + right - 1);
        
        
        return Math.max(left, right);
        
    }
    public int diameterOfBinaryTree(TreeNode root) {
        diameter(root);
        return count-1;
    }
}