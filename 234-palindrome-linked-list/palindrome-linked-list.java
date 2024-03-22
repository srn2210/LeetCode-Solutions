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
    boolean ans;
    ListNode start;
    void recurse(ListNode end) {
        if(end == null) return;
        recurse(end.next);
        if(start.val == end.val) start = start.next;
        else ans = false;
    }
    public boolean isPalindrome(ListNode head) {
        start = head;
        ans = true;
        recurse(head);
        return ans;
    }
}