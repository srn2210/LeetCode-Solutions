class Solution {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
            left = null;
            right = null;
        }
    }
    int ans;
    int dfs(TreeNode node) {
        if(node.left == null && node.right == null) {
            return node.val;
        }
        int left = dfs(node.left);
        int right = dfs(node.right);
        if(right > left) {
            ans += right - left;
            return right + node.val;
        }
        else {
            ans += left - right;
            return left + node.val;
        }
    }
    public int minIncrements(int n, int[] cost) {
        TreeNode[] nodes = new TreeNode[cost.length];
        for(int i=0; i<cost.length; i++) {
            nodes[i] = new TreeNode(cost[i]);
        }
        var q = new LinkedList<Pair<TreeNode, Integer>>();
        q.add(new Pair<>(nodes[0], 0));
        while(!q.isEmpty()) {
            int size = q.size();
            while(size-- > 0) {
                var node = q.peek().getKey();
                int idx = q.poll().getValue();
                if(idx * 2 + 2 < cost.length) {
                    node.left = nodes[idx * 2 + 1];
                    node.right = nodes[idx*2 + 2];
                    q.add(new Pair<>(node.left, idx*2+1));
                    q.add(new Pair<>(node.right, idx*2+2));
                }
            }
        }
        ans = 0;
        dfs(nodes[0]);
        return ans;
    }
}