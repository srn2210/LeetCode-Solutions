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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        var ans = new ArrayList<List<Integer>>();
        var queue = new LinkedList<TreeNode>();
        if(root != null) queue.add(root);
        var rev = false;
        while(!queue.isEmpty()) {
            int size = queue.size();
            var list = new ArrayList<Integer>();
            while(size-- > 0) {
                var r = queue.poll();
                list.add(r.val);
                if(r.left != null) queue.add(r.left);
                if(r.right != null) queue.add(r.right);
            }
            if(rev) Collections.reverse(list);
            ans.add(list);
            rev = !rev;
        }
        return ans;
    }
}