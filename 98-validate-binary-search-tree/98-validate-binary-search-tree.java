class Solution {
    boolean flag;
    void dfs(TreeNode node, Stack<Integer> list) {
        if(node.left != null) dfs(node.left, list);
        if(!list.isEmpty()) {
            if(list.peek() >= node.val) flag = false;
        }
        list.push(node.val);
        if(node.right != null) dfs(node.right, list);
    }
    public boolean isValidBST(TreeNode root) {
        flag = true;
        Stack<Integer> list = new Stack();
        dfs(root, list);
        return flag;
    }
}