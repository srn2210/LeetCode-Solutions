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
    ListNode reverse(ListNode start, int count, ListNode prev) {
        if(count == 1) return start;
        var node = start;
        while(count-- > 0) {
            var next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }
        return prev;
    }
    public ListNode reverseBetween(ListNode head, int left, int right) {
        var dummyHead = new ListNode();
        var res = dummyHead;
        dummyHead.next = head;
        int count = right - left + 1;
        for(int i=0; i<left-1; i++) dummyHead = dummyHead.next;
        var tail = dummyHead;
        for(int i=0; i<=count && tail != null; i++) tail = tail.next;
        var rev = reverse(dummyHead.next, count, tail);
        dummyHead.next = rev;
        return res.next;
    }
}