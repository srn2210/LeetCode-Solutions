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
    int idx = -1;
    TreeNode buildUtil(Map<Integer, Integer> map, int[] postorder, int[] inorder, int left, int right) {
        if(left > right || idx < 0) return null;
        int val = postorder[idx--];
        var root = new TreeNode(val);
        root.right = buildUtil(map, postorder, inorder, map.get(val) + 1, right);
        root.left = buildUtil(map, postorder, inorder, left, map.get(val)-1);
        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        var map = new HashMap<Integer, Integer>();
        for(int i=0; i<inorder.length; i++) {
            map.put(inorder[i], i);
        }
        idx = postorder.length-1;
        return buildUtil(map, postorder, inorder, 0, postorder.length-1);
    }
}