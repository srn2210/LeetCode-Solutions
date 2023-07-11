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
            if(dist == k) return q;
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