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
        while(curr != null) {
            Node copyNode = new Node(curr.val);
            Node t = curr.next;
            curr.next = copyNode;
            copyNode.next = t;
            curr = t;
        }
        curr = head;
        while(curr != null) {
            if(curr.random != null) curr.next.random = curr.random.next;
            curr = curr.next.next;
        }
        var dummy = new Node(0);
        var copy = dummy;
        curr = head;
        while(curr != null) {
            copy.next = curr.next;
            curr.next = curr.next.next;
            copy = copy.next;
            curr = curr.next;
        }
        return dummy.next;
    }
}