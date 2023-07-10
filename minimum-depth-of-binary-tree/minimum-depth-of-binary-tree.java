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
    public int minDepth(TreeNode root) {
        var q = new LinkedList<TreeNode>();
        if(root != null) q.add(root);
        int level = 1;
        while(!q.isEmpty()) {
            int s = q.size();
            while(s-- > 0) {
                var node = q.poll();
                if(node.left == null && node.right == null) return level;
                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
            }
            level++;
        }
        return 0;
    }
}