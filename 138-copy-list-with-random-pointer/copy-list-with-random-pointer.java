/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    Node giveNode(Map<Node, Node> map, Node node) {
        if(map.containsKey(node)) return map.get(node);
        else {
            Node n = new Node(node.val);
            map.put(node, n);
            return n;
        }
    }
    public Node copyRandomList(Node head) {
        var curr = head;
        var dummy = new Node(0);
        var curr2 = dummy;
        var map = new HashMap<Node, Node>();
        while(curr != null) {
            curr2.next = giveNode(map, curr);
            curr2 = curr2.next;
            if(curr.random != null) {
                curr2.random = giveNode(map, curr.random);
            }
            curr = curr.next;
        }
        return dummy.next;
    }
}