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
    Map<Pair<TreeNode, Boolean>, Integer> dp;
    int dfs(TreeNode node, boolean canTake) {
        if(node == null) return 0;
        var p = new Pair<TreeNode, Boolean>(node, canTake);
        if(dp.containsKey(p)) return dp.get(p);
        int ans = 0;
        if(canTake) {
            int childNotTake = 0;
            childNotTake += dfs(node.left, true);
            childNotTake += dfs(node.right, true);

            int childTake = node.val;
            childTake += dfs(node.left, false);
            childTake += dfs(node.right, false);
            ans = Math.max(ans, childTake);
            ans = Math.max(ans, childNotTake);
        }
        else {
            ans += dfs(node.left, true);
            ans += dfs(node.right, true);
        }
        dp.put(p, ans);
        return ans;
    }
    public int rob(TreeNode root) {
        dp = new HashMap<Pair<TreeNode, Boolean>, Integer>();
        int ans1 = dfs(root, true);
        int ans2 = dfs(root, false);
        return Math.max(ans1, ans2);
    }
}