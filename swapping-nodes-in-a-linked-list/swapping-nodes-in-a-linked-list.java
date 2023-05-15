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
    public ListNode swapNodes(ListNode head, int k) {
        var beg = head;
        var end = head;
        var endK = head;
        int curr = 1;
        int n = 0;
        while(end != null) {
            end = end.next;
            n++;
        }
        while(curr < k) {
            beg = beg.next;
            curr++;
        }
        curr = 1;
        while(curr != n-k+1) {
            endK = endK.next;
            curr++;
        }
        int t = beg.val;
        beg.val = endK.val;
        endK.val = t;
        return head;
    }
}