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
    void swap(ListNode prev, ListNode node1, ListNode node2) {
        var temp = node2.next;
        node2.next = node1;
        node1.next = temp;
        prev.next = node2;
    }
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode res = head.next;
        ListNode curr = head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        while(curr != null && curr.next != null) {
            swap(prev, curr, curr.next);
            prev = curr;
            curr = curr.next;
        }
        return res;
    }
}