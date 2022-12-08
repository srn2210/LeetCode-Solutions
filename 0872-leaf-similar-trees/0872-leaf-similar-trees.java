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
    void dfs(TreeNode node, List<Integer> list) {
        if(node == null) return;
        if(node.left == null && node.right == null) {
            list.add(node.val);
            return;
        }
        dfs(node.left, list);
        dfs(node.right, list);
        return;
    }
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> s1 = new ArrayList<>();
        List<Integer> s2 = new ArrayList<>();
        dfs(root1, s1);
        dfs(root2, s2);
        if(s1.size() != s2.size()) return false;
        for(int i=0; i<s1.size(); i++) {
            if(s1.get(i) != s2.get(i)) return false;
        }
        return true;
    }
}