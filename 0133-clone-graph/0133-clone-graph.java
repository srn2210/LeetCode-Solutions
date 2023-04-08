/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        var ans = new Node(node.val, new ArrayList<>());
        var map = new HashMap<Integer, Node>();
        map.put(node.val, ans);
        var queue = new LinkedList<Node>();
        queue.add(node);
        var vis = new HashSet<Node>();
        vis.add(node);
        while(!queue.isEmpty()) {
            var curr = queue.poll();
            var currCpy = map.get(curr.val);
            for(var nodes : curr.neighbors) {
                if(!map.containsKey(nodes.val)) map.put(nodes.val, new Node(nodes.val, new ArrayList<>()));
                currCpy.neighbors.add(map.get(nodes.val));
                if(!vis.contains(nodes)) {
                    vis.add(nodes);
                    queue.add(nodes);
                }
            }
        }
        return ans;
    }
}