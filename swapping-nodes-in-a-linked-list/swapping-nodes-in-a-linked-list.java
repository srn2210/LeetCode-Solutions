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
    void swap(ListNode beg, ListNode node) {
        int t = beg.val;
        beg.val = node.val;
        node.val = t;
    }
    public ListNode swapNodes(ListNode head, int k) {
        int curr = 1;
        ListNode it = head;
        ListNode beg = head;
        ListNode end = head;
        while(it != null) {
            if(curr == k) beg = it;
            if(curr > k) end = end.next;
            it = it.next;
            curr++;
        }
        swap(beg, end);
        return head;
    }
}