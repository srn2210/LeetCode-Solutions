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
    int ans;
    Pair<Integer, Integer> dfs(TreeNode node) {
        if(node.left == null && node.right == null) return new Pair(node.val, node.val);
        int left = Integer.MIN_VALUE, right = Integer.MAX_VALUE;
        Pair<Integer, Integer> t1 = null, t2 = null;
        if(node.left != null) t1 = dfs(node.left);
        if(node.right != null) t2 = dfs(node.right);
        if(t1 != null) left = Math.max(left, t1.getValue());
        if(t2 != null) right = Math.min(right, t2.getKey());
        left = left == Integer.MIN_VALUE ? Integer.MAX_VALUE : left;
        ans = Math.min(ans, Math.min(Math.abs(left-node.val), Math.abs(right-node.val)));
        int a1 = node.val, a2 = node.val;
        if(t1 != null) a1 = Math.min(a1, t1.getKey());
        if(t2 != null) a2 = Math.max(a2, t2.getValue());
        return new Pair(a1, a2);
    }
    public int minDiffInBST(TreeNode root) {
        ans = Integer.MAX_VALUE;
        dfs(root);
        return ans;
    }
}