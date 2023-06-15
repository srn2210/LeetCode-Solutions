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
    public int maxLevelSum(TreeNode root) {
        var q = new LinkedList<TreeNode>();
        q.add(root);
        int ans = 1, sum = Integer.MIN_VALUE, level = 1;
        while(!q.isEmpty()) {
            int size = q.size();
            int curr = 0;
            while(size-- > 0) {
                var node = q.poll();
                curr += node.val;
                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
            }
            if(curr > sum) {
                ans = level;
                sum = curr;
            }
            level++;
        }
        return ans;
    }
}