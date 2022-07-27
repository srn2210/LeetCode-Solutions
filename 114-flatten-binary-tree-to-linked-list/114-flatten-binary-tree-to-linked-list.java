class Solution {
    void pre(TreeNode root, TreeNode node) {
        if(root == null) return;
        
        pre(root.left, node);
        pre(root.right, node);
        if(root.left != null) {
            
            node = root.right;
            root.right = root.left;
            root.left = null;
            TreeNode temp = root;
            while(temp.right != null) {
                temp = temp.right;
            }
            temp.right = node;            
        }
    }
    public void flatten(TreeNode root) {
        TreeNode node = new TreeNode(0);
        pre(root, node);
    }
}