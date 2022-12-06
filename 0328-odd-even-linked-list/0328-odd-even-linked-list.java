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
    public ListNode oddEvenList(ListNode head) {
        ListNode curr = head;
        ListNode odd = new ListNode(0);
        ListNode oddHead = odd;
        ListNode even = new ListNode(0);
        ListNode evenHead = even;
        boolean flag = true;
        while(curr != null) {
            if(flag) {
                odd.next = curr;
                odd = odd.next;
            }
            else{
                even.next = curr;
                even = even.next;
            }
            curr = curr.next;
            flag = !flag;
        }
        oddHead = oddHead.next;
        evenHead = evenHead.next;
        odd.next = evenHead;
        even.next = null;
        return oddHead;
    }
}