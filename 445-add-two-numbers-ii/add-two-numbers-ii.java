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
    ListNode reverse(ListNode list) {
        ListNode prev = list;
        list = list.next;
        prev.next = null;
        while(list != null) {
            ListNode next = list.next;
            list.next = prev;
            prev = list;
            list = next;
        }
        return prev;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverse(l1);
        l2 = reverse(l2);
        int carry = 0;
        ListNode ans = new ListNode(0);
        ListNode curr = ans;
        while(l1 != null || l2 != null || carry != 0) {
            int l1val = l1 == null ? 0 : l1.val;
            int l2val = l2 == null ? 0 : l2.val;
            int val = l1val + l2val + carry;
            curr.next = new ListNode(val%10);
            curr = curr.next;
            carry = val / 10;
            l1 = l1 == null ? l1 : l1.next;
            l2 = l2 == null ? l2 : l2.next;
        }
        return reverse(ans.next);
    }
}