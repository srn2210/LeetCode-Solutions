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
    public boolean isCompleteTree(TreeNode root) {
        var flag = false;
        var queue = new LinkedList<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty()) {
            var node = queue.poll();
            if(node == null) flag = true;
            else {
                if(flag) return false;
                queue.add(node.left);
                queue.add(node.right);
            }
        }
        return true;
    }
}