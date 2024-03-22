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
    ListNode start;
    boolean recurse(ListNode end) {
        if(end == null) return true;
        if(recurse(end.next) && start.val == end.val) {
            start = start.next;
            return true;
        }
        return false;
    }
    public boolean isPalindrome(ListNode head) {
        start = head;
        return recurse(head);
    }
}