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
    void reverse(ListNode head, ListNode tail) {
        ListNode prev = new ListNode();
        ListNode curr = head.next;
        ListNode end = null;
        while(curr != tail) {
            ListNode next = curr.next;
            if(next == tail) {
                end = curr;
            }
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head.next.next = tail;
        head.next = end;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode curr = dummy.next, start = dummy;
        int count = 0;
        while(curr != null) {
            count++;
            var next = curr.next;
            if(count == k) {
                var t = start.next;
                reverse(start, curr.next);
                count = 0;
                start = t;
            }
            curr = next;
        }
        return dummy.next;
    }
}