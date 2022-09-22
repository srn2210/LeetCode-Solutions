class Solution {
    boolean flag = true;
    void dfs(TreeNode node, ArrayList<Integer> list) {
        if(node.left != null) dfs(node.left, list);
        if(list.size() != 0) {
            if(list.get(list.size()-1) >= node.val) flag = false;
        }
        list.add(node.val);
        if(node.right != null) dfs(node.right, list);
    }
    public boolean isValidBST(TreeNode root) {
        ArrayList<Integer> list = new ArrayList();
        dfs(root, list);
        /*for(int i=1; i<list.size(); i++) {
            if(list.get(i) <= list.get(i-1)) return false;
        }*/
        return flag;
    }
}