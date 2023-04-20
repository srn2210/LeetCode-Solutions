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
    public int widthOfBinaryTree(TreeNode root) {
        var q = new LinkedList<Pair<Integer, TreeNode>>();
        q.add(new Pair(0, root));
        int ans = Integer.MIN_VALUE;
        while(!q.isEmpty()) {
            int size = q.size();
            int lo = Integer.MAX_VALUE;
            int hi = Integer.MIN_VALUE;
            while(size-- > 0) {
                var t = q.poll();
                var idx = t.getKey();
                var node = t.getValue();
                if(node.left != null) q.add(new Pair(idx*2 + 1, node.left));
                if(node.right != null) q.add(new Pair(idx*2 + 2, node.right));
                lo = Math.min(lo, idx);
                hi = Math.max(hi, idx);
            }
            ans = Math.max(hi - lo + 1, ans);
        }
        return ans;
    }
}