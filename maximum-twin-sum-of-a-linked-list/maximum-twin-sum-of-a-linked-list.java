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
    int len;
    ListNode dummy;
    ListNode reverseHead(ListNode node, int curr) {
        if(node == null) {
            len = curr;
            dummy = new ListNode();
            return dummy;
        }
        var next = reverseHead(node.next, curr+1);
        if(curr == len / 2) node.next = null;
        if(curr < len / 2) return null;
        next.next = node;
        return node;
    }
    public int pairSum(ListNode head) {
        reverseHead(head, 0);
        ListNode curr = head;
        ListNode rev = dummy.next;
        int max = Integer.MIN_VALUE;
        while(rev != null && curr != null) {
            max = Math.max(curr.val + rev.val, max);
            curr = curr.next;
            rev = rev.next;
        }
        return max;
    }
}