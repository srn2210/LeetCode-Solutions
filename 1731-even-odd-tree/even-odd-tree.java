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
    public boolean isEvenOddTree(TreeNode root) {
        var q = new LinkedList<TreeNode>();
        q.add(root);

        int row = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            int prev = row % 2 == 0 ? 0 : Integer.MAX_VALUE;
            while(size-- > 0) {
                var node = q.poll();
                if(row % 2 == 0 && (node.val % 2 == 0 || node.val <= prev)) return false;
                if(row % 2 != 0 && (node.val % 2 != 0 || node.val >= prev)) return false;
                prev = node.val;
                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
            }
            row++;
        }

        return true;
    }
}