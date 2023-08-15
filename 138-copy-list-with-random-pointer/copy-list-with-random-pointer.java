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
    int getIndex(Node random) {
        int count = 0;
        while(random != null) {
            random = random.next;
            count++;
        }
        return count;
    }
    public Node copyRandomList(Node head) {
        var curr = head;
        int len = getIndex(head);
        //System.out.println("len = "+len);
        int idx = 0;
        var dummy = new Node(0);
        var newNode = dummy;
        var map = new HashMap<Integer, Node>();
        while(curr != null) {
            if(map.containsKey(idx)) {
                newNode.next = map.get(idx);
                newNode = newNode.next;
            }
            else {
                Node t = new Node(curr.val);
                newNode.next = t;
                newNode = t;
                map.put(idx, t);
            }
            if(curr.random != null) {
                int ind = getIndex(curr.random);
                ind = len - ind;
                //System.out.println(idx + " is the idx and the index is"+ind);
                if(map.containsKey(ind)) {
                    newNode.random = map.get(ind);
                }
                else {
                    Node t = new Node(curr.random.val);
                    map.put(ind, t);
                    newNode.random = t;
                }
            }
            idx++;
            curr = curr.next;
        }
        return dummy.next;
    }
}