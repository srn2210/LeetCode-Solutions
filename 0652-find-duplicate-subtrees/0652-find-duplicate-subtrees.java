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
    List<TreeNode> ans;
    StringBuilder dfs(TreeNode node, Map<String, Integer> map) {
        if(node == null) return new StringBuilder('#');
        StringBuilder t = new StringBuilder();
        t.append(node.val).append(',');
        t.append(dfs(node.left, map)).append(',');
        t.append(dfs(node.right, map));
        String s = t.toString();
        map.put(s, map.getOrDefault(s,0)+1);
        if(map.get(s) == 2) ans.add(node);
        return t;
    }
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        ans = new LinkedList<>();
        var map = new HashMap<String, Integer>();
        dfs(root, map);
        return ans;
    }
}