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
                if(rev) {
                    var r = queue.removeLast();
                    list.add(r.val);
                    if(r.right != null) queue.addFirst(r.right);
                    if(r.left != null) queue.addFirst(r.left);
                }
                else {
                    var r = queue.removeFirst();
                    list.add(r.val);
                    if(r.left != null) queue.addLast(r.left);
                    if(r.right != null) queue.addLast(r.right);
                }
            }
            ans.add(list);
            rev = !rev;
        }
        return ans;
    }
}