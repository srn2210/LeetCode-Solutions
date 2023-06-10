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
        ListNode dummy = new ListNode();
        ListNode prev = dummy;
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
        ListNode t = head.next;
        t.next = tail;
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
                //System.out.println(start.val + " " + curr.val);
                var t = start.next;
                reverse(start, curr.next);
                count = 0;
                start = t;
            }
            //start = curr;
            curr = next;
        }
        return dummy.next;
    }
}