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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = null;
        int cnt = 0;
        while(fast.next != null) {
            fast = fast.next;
            cnt++;
            if(cnt == n) slow = head;
            if(cnt > n) slow = slow.next;
        }
        if(slow == null) return head.next;
        slow.next = slow.next.next;
        return head;
    }
}