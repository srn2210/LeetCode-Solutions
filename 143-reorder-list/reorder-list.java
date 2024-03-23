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
    ListNode reverseNewHead;
    ListNode reverse(ListNode node) {
        if(node == null) return reverseNewHead = new ListNode();
        var prev = reverse(node.next);
        prev.next = node;
        node.next = null;
        return node;
    }
    public void reorderList(ListNode head) {
        var fast = head;
        var slow = head;
        while(fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        reverse(slow.next);
        slow.next = null;
        var node = head;
        var sec = reverseNewHead.next;
        while(node != null && sec != null) {
            var next = node.next;
            node.next = sec;
            var nextSec = sec.next;
            sec.next = next;
            node = next;
            sec = nextSec;
        }
    }
}