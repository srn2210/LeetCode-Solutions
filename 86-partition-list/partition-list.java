/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    ListNode addNode(ListNode node, ArrayDeque<ListNode> st) {
        if(node == null && !st.isEmpty()) {
            node = st.pop();
            node.next = null;
        }
        while(!st.isEmpty()) {
            var curr = st.pop();
            curr.next = node;
            node = curr;
        }
        return node;
    }
    public ListNode partition(ListNode head, int x) {
        var curr = head;
        var greater = new ArrayDeque<ListNode>();
        var lesser = new ArrayDeque<ListNode>();
        while(curr != null) {
            if(curr.val < x) lesser.push(curr);
            else greater.push(curr);
            curr = curr.next;
        }
        ListNode prev = null;
        prev = addNode(prev, greater);
        return addNode(prev, lesser);
    }
}