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
    Map<Integer, List<TreeNode>> dp;
    List<TreeNode> solve(int n) {
        var ans = new ArrayList<TreeNode>();
        if(n == 1) {
            ans.add(new TreeNode());
            return ans;
        }
        if(dp.containsKey(n)) return dp.get(n);
        for(int i=1; i<n; i+=2) {
            var left = solve(i);
            var right = solve(n-i-1);
            for(int j=0; j<left.size(); j++) {
                for(int k=0; k<right.size(); k++) {
                    ans.add(new TreeNode(0, left.get(j), right.get(k)));
                }
            }
        }
        dp.put(n, ans);
        return ans;
    }
    public List<TreeNode> allPossibleFBT(int n) {
        if(n % 2 == 0) return new ArrayList<>();
        dp = new HashMap<Integer, List<TreeNode>>();
        return solve(n);
    }
}