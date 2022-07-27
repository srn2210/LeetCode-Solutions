class Solution {
    int bends = 0;
    void helper(TreeNode node, int turns, boolean dir) {
        if(turns > bends) {
            bends = turns;
        }
        if(node == null) {
            return;
        }
        
        if(node.left != null) {
            if(!dir) {
                helper(node.left, turns+1, !dir);
            }
            else {
                helper(node.left, 1, dir);
            }
        }
        
        if(node.right != null) {
            if(dir) {
                helper(node.right, turns+1, !dir);
            }
            else {
                helper(node.right, 1, dir);
            }
        }
        
    }
    public int longestZigZag(TreeNode root) {
        helper(root, 0, true);
        return bends;
    }
}