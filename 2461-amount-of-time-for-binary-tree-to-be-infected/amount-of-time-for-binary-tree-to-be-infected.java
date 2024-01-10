/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    void convertToGraph(TreeNode node, Map<Integer, List<Integer>> adj, int parent) {
        if(node == null) return;
        if(node.left != null) {
            adj.computeIfAbsent(node.val, a -> new ArrayList<>()).add(node.left.val);
        }
        if(node.right != null) {
            adj.computeIfAbsent(node.val, a -> new ArrayList<>()).add(node.right.val);
        }
        if(parent != 0) {
            adj.computeIfAbsent(node.val, a -> new ArrayList<>()).add(parent);
        }
        convertToGraph(node.left, adj, node.val);
        convertToGraph(node.right, adj, node.val);
    }
    public int amountOfTime(TreeNode root, int start) {
        var adj = new HashMap<Integer, List<Integer>>();
        convertToGraph(root, adj, 0);

        var q = new LinkedList<Integer>();
        q.add(start);
        var visited = new HashSet<Integer>();

        int ans = -1;
        while(!q.isEmpty()) {
            int size = q.size();
            while(size-- > 0) {
                var next = q.poll();
                visited.add(next);
                for(int neigh : adj.getOrDefault(next, new ArrayList<>())) {
                    if(visited.contains(neigh)) continue;
                    else q.add(neigh);
                }
            }
            ans++;
        }
        return ans;
    }
}