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
        var queue = new LinkedList<TreeNode>();
        queue.add(root);
        int nodes = 1;
        while(!queue.isEmpty()) {
            int size = queue.size();
            int levelNodes = size;
            var q = new LinkedList<TreeNode>();
            for(int i=0; i<size; i++) {
                var node = queue.poll();
                if(node.left == null && node.right != null) return false;
                if(node.left != null) {
                    if(q.size() != i * 2) return false;
                }
                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
            }
            queue = q;
            if(!queue.isEmpty() && nodes != levelNodes) return false;
            nodes *= 2;
        }
        return true;
    }
}