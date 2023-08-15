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
    public Node copyRandomList(Node head) {
        var curr = head;
        var dummy = new Node(0);
        var curr2 = dummy;
        var map = new HashMap<Node, Node>();
        while(curr != null) {
            if(map.containsKey(curr)) {
                curr2.next = map.get(curr);
                curr2 = curr2.next;
            }
            else {
                Node t = new Node(curr.val);
                curr2.next = t;
                curr2 = curr2.next;
                map.put(curr, t);
            }
            if(curr.random != null) {
                if(map.containsKey(curr.random)) {
                    curr2.random = map.get(curr.random);
                    //curr2 = curr2.next;
                }
                else {
                    Node t = new Node(curr.random.val);
                    curr2.random = t;
                    //curr2 = curr2.next;
                    map.put(curr.random, t);
                }
            }
            curr = curr.next;
        }
        return dummy.next;
    }
}