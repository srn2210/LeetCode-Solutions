/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    /*int ref;
    int dfs(TreeNode node, TreeNode target, int k, List<Integer> ans) {
        if(node == null) return 0;
        if(k == 0) ans.add(node.val);
        if(flag) {
            int left = node.left == null ? 0 : 1 + dfs(node.left, target, k-1, ans);
            int right = node.right == null ? 0 : 1 + dfs(node.right, target, k-1, ans);
            if(left + right == ref) ans.add(node.val);
        }
        else {
            int left = node.left == null ? 0 : 1 + dfs(node.left, target, k, ans);
            int right = node.right == null ? 0 : 1 + dfs(node.right, target, k, ans);
            if(left + right == ref) ans.add(node.val);
        }
        if(node.val == target.val) return 1;
        else return 0;
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        var ans = new ArrayList<Integer>();
        ref = k;
        dfs(root, target, k, ans);
        return ans;
    }*/
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        var adj = new HashMap<Integer, List<Integer>>();
        var g = new LinkedList<TreeNode>();
        g.add(root);
        while(!g.isEmpty()) {
            var s = g.size();
            while(s-- > 0) {
                var node = g.poll();
                if(node.left != null) {
                    adj.computeIfAbsent(node.val, a -> new ArrayList<>()).add(node.left.val);
                    adj.computeIfAbsent(node.left.val, a -> new ArrayList<>()).add(node.val);
                    g.add(node.left);
                }
                if(node.right != null) {
                    adj.computeIfAbsent(node.val, a -> new ArrayList<>()).add(node.right.val);
                    adj.computeIfAbsent(node.right.val, a -> new ArrayList<>()).add(node.val);
                    g.add(node.right);
                }
            }
        }
        var q = new LinkedList<Integer>();
        q.add(target.val);
        var set = new HashSet<Integer>();
        set.add(target.val);
        int dist = 0;
        while(!q.isEmpty()) {
            var s = q.size();
            if(dist == k) {
                /*var ans = new ArrayList<Integer>();
                while(!q.isEmpty()) {
                    ans.add(q.poll());
                }
                return ans;*/
                return q;
            }
            while(s-- > 0) {
                var node = q.poll();
                if(!adj.containsKey(node)) continue;
                for(int neigh : adj.get(node)) {
                    if(!set.contains(neigh)) {
                        set.add(neigh);
                        q.add(neigh);
                    }
                }
            }
            dist++;
        }
        return new ArrayList<Integer>();
    }
}