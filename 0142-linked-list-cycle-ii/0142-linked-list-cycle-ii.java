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
    public ListNode detectCycle(ListNode head) {
        var dummy = head;
        var set = new HashSet<ListNode>();
        while(dummy != null) {
            if(set.contains(dummy)) return dummy;
            set.add(dummy);
            dummy = dummy.next;
        }
        return null;
    }
}