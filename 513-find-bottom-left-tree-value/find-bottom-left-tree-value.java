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
    public int findBottomLeftValue(TreeNode root) {
        var q = new LinkedList<TreeNode>();
        q.add(root);
        int ans = root.val;

        while(!q.isEmpty()) {
            int size = q.size();
            ans = q.peek().val;
            while(size-- > 0) {
                var t = q.poll();
                if(t.left != null) q.add(t.left);
                if(t.right != null) q.add(t.right);

            }
        }

        return ans;
    }
}