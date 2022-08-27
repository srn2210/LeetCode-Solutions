class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return new ArrayList();
        
        List<List<Integer>> res = new ArrayList();
        Queue<TreeNode> queue = new LinkedList();
        
        queue.offer(root);
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList();
            while(size-- > 0) {
                TreeNode temp = queue.poll();
                list.add(temp.val);
                if(temp.left != null) {
                    queue.offer(temp.left);
                }
                if(temp.right != null) {
                    queue.offer(temp.right);
                }
            }
            res.add(list);
        }
        
        return res;
    }
}