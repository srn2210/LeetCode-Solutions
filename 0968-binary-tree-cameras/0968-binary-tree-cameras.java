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
    int solve(TreeNode node, int status, Map<TreeNode, int[]> dp) {
        if(node == null) {
            if(status == 1) return 1001;
            return 0;
        }
        if(dp.containsKey(node) && dp.get(node)[status] != -1) return dp.get(node)[status];
        if(status == 1) {
            int ans = solve(node.left, 2, dp) + solve(node.right, 2, dp);
            dp.computeIfAbsent(node, a -> new int[]{-1, -1, -1, -1})[status] = ans;
            return ans;
        }
        else if(status == 2) {
            int setCam = 1 + solve(node.left, 2, dp) + solve(node.right, 2, dp);
            int noCam = solve(node.left, 3, dp) + solve(node.right, 3, dp);
            int ans = Math.min(setCam, noCam);
            dp.computeIfAbsent(node, a -> new int[]{-1, -1, -1, -1})[status] = ans;
            return ans;
        }
        else {
            int setCam = 1 + solve(node.left, 2, dp) + solve(node.right, 2, dp);
            int leftCam = 1 + solve(node.left, 1, dp) + solve(node.right, 3, dp);
            int rightCam = 1 + solve(node.left, 3, dp) + solve(node.right, 1, dp);
            int ans = Math.min(setCam, Math.min(leftCam, rightCam));
            dp.computeIfAbsent(node, a -> new int[]{-1, -1, -1, -1})[status] = ans;
            return ans;
        }
    }
    public int minCameraCover(TreeNode root) {
        var dp = new HashMap<TreeNode, int[]>();
        return solve(root, 3, dp);
    }
}