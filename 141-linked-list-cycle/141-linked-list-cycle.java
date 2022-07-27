/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null){return false;}
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast.next != null && fast.next.next != null && slow != null){
            if(slow == null || fast == null) {
                return false;
            }
            else if(slow == fast) return true;
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }
}