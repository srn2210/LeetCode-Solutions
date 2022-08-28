class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        
        HashMap<Integer, Node> map = new HashMap<Integer, Node>();
        Queue<Node> queue = new LinkedList<Node>();
        
        queue.offer(node);
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            while(size-- > 0) {
                Node temp = queue.poll();
                Node n = map.containsKey(temp.val) ? map.get(temp.val) : map.put(temp.val, new Node(temp.val));
                n = map.get(temp.val);
                List<Node> list = new ArrayList();
                for(Node i:temp.neighbors) {
                    if(map.containsKey(i.val)) {
                        list.add(map.get(i.val));
                        continue;
                    }
                    Node t = new Node(i.val);
                    map.put(t.val, t);
                    list.add(t);
                    queue.offer(i);
                }
                n.neighbors = list;
            }
        }
        
        return map.get(1);
    }
}