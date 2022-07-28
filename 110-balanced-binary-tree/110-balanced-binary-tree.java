class Solution {
    //int left = 0;
    //int right = 0;
    boolean ans = true;
    int dfs(TreeNode node) {
        if(node == null) return 0;
        int left = 0;
        int right = 0;
        left += dfs(node.left);
        right += dfs(node.right);
        
        //System.out.println("node = "+node.val+"....left = "+left+"...right = "+right);
        if(Math.abs(left - right) > 1) ans = false;
        if(left == 0 && right == 0) return 1;
        return left > right ? left+1 : right+1;
    }
    public boolean isBalanced(TreeNode root) {
        dfs(root);
        /*boolean reached = false;
        if(root == null) return true;
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        int height = 0;
        int low = Integer.MIN_VALUE;
        while(!queue.isEmpty()) {
            int width = queue.size();
            height++;
            while(width-- > 0) {
                TreeNode temp = queue.poll();
                if(temp.left != null) queue.add(temp.left);
                if(temp.right != null) queue.add(temp.right);
                if(height == 1 && (temp.left == null || temp.right == null)) low = height;
                if(temp.left == null && temp.right == null && low == Integer.MIN_VALUE) low = height;
            }
            //System.out.println("height = "+height+"...low = "+low);
            if(low != Integer.MIN_VALUE && height - low > 1) return false;
        }*/
        return ans;
    }
}