class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList();
        Queue<TreeNode> queue = new LinkedList();
        
        if(root == null) return list;
        
        queue.add(root);
        
        while(!queue.isEmpty()) {
            int width = queue.size();
            List<Integer> lt = new ArrayList();
            while(width > 0){
                TreeNode temp = queue.poll();
                lt.add(temp.val);
                if(temp.left != null){
                    queue.add(temp.left);
                }
                if(temp.right != null){
                    queue.add(temp.right);
                }
                width--;
            }
            list.add(new ArrayList(lt));
        }
        
        return list;
    }
}