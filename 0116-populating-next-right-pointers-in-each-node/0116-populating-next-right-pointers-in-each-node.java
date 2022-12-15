/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        Queue<Node> queue = new LinkedList<>();
        Queue<Node> t = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            while(size-- > 0) {
                Node temp = queue.poll();
                if(temp == null) continue;
                if(!queue.isEmpty()) temp.next = queue.peek();
                if(temp.left != null) t.offer(temp.left);
                if(temp.right != null) t.offer(temp.right);
            }
            queue = t;
            t = new LinkedList();
        }
        return root;
    }
}