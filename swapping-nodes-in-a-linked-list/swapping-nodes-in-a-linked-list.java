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
    ListNode begN;
    void swap(ListNode node) {
        int t = begN.val;
        begN.val = node.val;
        node.val = t;
    }
    int solve(ListNode head, int beg, int end, int k) {
        if(head == null) return 0;
        if(beg == k) begN = head;
        int pos = 1 + solve(head.next, beg+1, end, k);
        if(pos == k) swap(head);
        return pos;
    }
    public ListNode swapNodes(ListNode head, int k) {
        solve(head, 1, 0, k);
        return head;
    }
}