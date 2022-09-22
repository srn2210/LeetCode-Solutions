class Solution {
    boolean flag = true;
    void dfs(TreeNode node, Stack<Integer> list) {
        if(node.left != null) dfs(node.left, list);
        if(!list.isEmpty()) {
            if(list.peek() >= node.val) flag = false;
        }
        list.push(node.val);
        if(node.right != null) dfs(node.right, list);
    }
    public boolean isValidBST(TreeNode root) {
        Stack<Integer> list = new Stack();
        dfs(root, list);
        return flag;
    }
}