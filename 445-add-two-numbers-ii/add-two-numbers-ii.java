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
    void push(ListNode list, ArrayDeque<Integer> st) {
        while(list != null) {
            st.push(list.val);
            list = list.next;
        }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        var st1 = new ArrayDeque<Integer>();
        var st2 = new ArrayDeque<Integer>();
        push(l1, st1);
        push(l2, st2);
        int carry = 0;
        var st3 = new ArrayDeque<Integer>();
        ListNode ans = new ListNode();
        ListNode res = ans;
        while(!st1.isEmpty() || !st2.isEmpty() || carry != 0) {
            int val1 = st1.isEmpty() ? 0 : st1.pop();
            int val2 = st2.isEmpty() ? 0 : st2.pop();
            int val = val1 + val2 + carry;
            st3.push(val%10);
            carry = val / 10;
        }
        while(!st3.isEmpty()) {
            ans.next = new ListNode(st3.pop());
            ans = ans.next;
        }
        return res.next;
    }
}