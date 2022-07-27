class Solution {
    private void recurse(TreeNode node, List list, int depth) {
        if(node != null){
            if(depth == list.size()){
            list.add(node.val);
            }
            recurse(node.right, list, depth+1);
            recurse(node.left, list, depth+1);
        }
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList();
        
        recurse(root, list, 0);
        
        return list;
    }
}