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
    void swap(ListNode prev, ListNode curr, ListNode next) {
        var temp = next.next;
        next.next = curr;
        curr.next = temp;
        prev.next = next;
    }
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode curr = head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        while(curr != null && curr.next != null) {
            swap(prev, curr, curr.next);
            prev = curr;
            curr = curr.next;
        }
        return dummy.next;
    }
}