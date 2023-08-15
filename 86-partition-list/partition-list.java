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
        if(!greater.isEmpty()) {
            prev = greater.pop();
            prev.next = null;
        }
        while(!greater.isEmpty()) {
            var node = greater.pop();
            node.next = prev;
            prev = node;
        }
        if(prev == null && !lesser.isEmpty()) {
            prev = lesser.pop();
            prev.next = null;
        }
        while(!lesser.isEmpty()) {
            var node = lesser.pop();
            node.next = prev;
            prev = node;
        }
        return prev;
    }
}