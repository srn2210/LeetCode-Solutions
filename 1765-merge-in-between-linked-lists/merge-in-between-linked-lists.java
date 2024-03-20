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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode prev = null;
        ListNode curr = list1;
        int num = 0;
        while(num != a) {
            prev = curr;
            curr = curr.next;
            
            num++;
        }
        while(num != b) {
            curr = curr.next;
            num++;
        }
        prev.next = list2;
        ListNode head = list2;
        while(head.next != null) {
            head = head.next;
        }
        head.next = curr.next;
        return list1;
    }
}