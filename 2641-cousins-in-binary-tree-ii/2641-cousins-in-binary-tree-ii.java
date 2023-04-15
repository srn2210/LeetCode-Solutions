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
    void dfs(TreeNode node, List<Integer> list, int depth, int sum) {
        if(node == null) return;
        int add = 0;
        node.val = list.get(depth) - sum;
        if(node.left != null) add += node.left.val;
        if(node.right != null) add += node.right.val;
        dfs(node.left, list, depth+1, add);
        dfs(node.right, list, depth+1, add);
    }
    public TreeNode replaceValueInTree(TreeNode root) {
        var q = new LinkedList<TreeNode>();
        q.add(root);
        var list = new ArrayList<Integer>();
        while(!q.isEmpty()) {
            int size = q.size();
            int sum = 0;
            while(size-- > 0) {
                var t = q.poll();
                sum += t.val;
                if(t.left != null) q.add(t.left);
                if(t.right != null) q.add(t.right);
            }
            list.add(sum);
        }
        dfs(root, list, 0, root.val);
        return root;
    }
}