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
    List<TreeNode>[][] dp;
    List<TreeNode> solve(int start, int end) {
        var ans = new ArrayList<TreeNode>();
        if(start > end) {
            ans.add(null);
            return ans;
        }
        if(dp[start][end] != null) return dp[start][end];
        for(int i=start; i<=end; i++) {
            var left = solve(start, i-1);
            var right = solve(i+1, end);
            for(int j=0; j<left.size(); j++) {
                for(int k=0; k<right.size(); k++) {
                    ans.add(new TreeNode(i, left.get(j), right.get(k)));
                }
            }
        }
        return dp[start][end] = ans;
    }
    public List<TreeNode> generateTrees(int n) {
        dp = new List[n+1][n+1];
        return solve(1, n);
    }
}