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
        
        HashMap<Integer, Node> map = new HashMap();
        Queue<Node> queue = new LinkedList();
        
        queue.offer(node);
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            while(size-- > 0) {
                Node temp = queue.poll();
                Node n = map.containsKey(temp.val) ? map.get(temp.val) : new Node();
                n.val = temp.val;
                if(!map.containsKey(n.val)) {
                    map.put(n.val, n);
                }
                List<Node> list = new ArrayList<Node>();
                for(int i=0; i<temp.neighbors.size(); i++) {
                    if(map.containsKey(temp.neighbors.get(i).val)) {
                        list.add(map.get(temp.neighbors.get(i).val));
                        continue;
                    }
                    Node t = new Node();
                    t.val = temp.neighbors.get(i).val;
                    map.put(t.val, t);
                    list.add(t);
                    queue.offer(temp.neighbors.get(i));
                }
                n.neighbors = list;
            }
        }
        
        return map.get(1);
    }
}