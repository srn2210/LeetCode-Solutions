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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int prev=0, temp = 0;
        ListNode l3 = new ListNode();
        ListNode n = new ListNode();
        l3 = n;
        while(l1 != null || l2 !=null || prev != 0){
            if((l1 == null && l2 == null) && prev !=0){
                n.val = 1;
                break;
            }
            if(l1 != null && l2 != null){
             temp = l1.val + l2.val;   
            }
            else if(l1 == null && l2 != null){
                temp = l2.val;
            }
            else if(l1 != null && l2 == null){
                temp = l1.val;
            }
            n.val = temp;
            if(prev == 1){
                n.val = n.val + 1;
                prev = 0;
            }
            if(n.val > 9){
                n.val = n.val % 10;
                prev++;
            }
            if(l1 != null){
             l1 = l1.next;   
            }
            if(l2 != null){
             l2 = l2.next;   
            }
            if(prev != 0 || l1 != null || l2 != null){
             n.next = new ListNode();   
            }
            n = n.next;
        }
        return l3;
    }
}