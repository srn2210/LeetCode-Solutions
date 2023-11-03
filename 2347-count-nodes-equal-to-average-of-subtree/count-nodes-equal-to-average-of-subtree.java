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
    Pair<Integer, Integer> solve(TreeNode node) {
        if(node == null) return new Pair<>(0, 0);
        var p1 = solve(node.left);
        var p2 = solve(node.right);
        int sum = p1.getKey() + p2.getKey() + node.val;
        int nodes = p1.getValue() + p2.getValue() + 1;
        if(sum / nodes == node.val) ans++;
        return new Pair<>(sum, nodes);
    }
    public int averageOfSubtree(TreeNode root) {
        ans = 0;
        solve(root);
        return ans;
    }
}