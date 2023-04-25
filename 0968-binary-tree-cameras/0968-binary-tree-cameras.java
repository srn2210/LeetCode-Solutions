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
    // status 1 == hasCameraAtThatNode
    // status 2 == doesNotHaveCamButBeingMonitored
    // status 3 == noCamAndNotMonitored
    int solve(TreeNode node, int status, Map<TreeNode, int[]> dp) {
        if(node == null) {
            if(status == 1) return 1001;                // cannot set camera on a non existant node, so return big number
            return 0;
        }
        if(dp.containsKey(node) && dp.get(node)[status] != -1) return dp.get(node)[status];         // memo
        if(status == 1) {               // has a cam, so its children will be monitored
            int ans = solve(node.left, 2, dp) + solve(node.right, 2, dp);
            dp.computeIfAbsent(node, a -> new int[]{-1, -1, -1, -1})[status] = ans;
            return ans;
        }
        else if(status == 2) {          // is being monitored, so two choices put cam on this node or not
            int setCam = 1 + solve(node.left, 2, dp) + solve(node.right, 2, dp);        // set cam on the node, update child to beingMonitored
            int noCam = solve(node.left, 3, dp) + solve(node.right, 3, dp);             // No cam on the node, child will be unMonitored
            int ans = Math.min(setCam, noCam);
            dp.computeIfAbsent(node, a -> new int[]{-1, -1, -1, -1})[status] = ans;
            return ans;
        }
        else {                          // unMonitored, we can set cam here, or set a cam to the left or right child
            int setCam = 1 + solve(node.left, 2, dp) + solve(node.right, 2, dp);        // set cam here same as previous
            int leftCam = 1 + solve(node.left, 1, dp) + solve(node.right, 3, dp);       // set cam at left child, right child unMonitored
            int rightCam = 1 + solve(node.left, 3, dp) + solve(node.right, 1, dp);      // set cam at right child, left child unMonitored
            int ans = Math.min(setCam, Math.min(leftCam, rightCam));
            dp.computeIfAbsent(node, a -> new int[]{-1, -1, -1, -1})[status] = ans;
            return ans;
        }
    }
    public int minCameraCover(TreeNode root) {
        var dp = new HashMap<TreeNode, int[]>();            // cache soln for each node for each status through 1,2,3
        return solve(root, 3, dp);
    }
}