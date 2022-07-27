class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode lesser = new ListNode(0);
        ListNode greater = new ListNode(0);
        
        ListNode temp3 = new ListNode();
        ListNode temp2 = new ListNode();
        
        temp3 = lesser;
        temp2 = greater;
        
        while(head != null) {
            if(head.val < x) {
                lesser.next = head;
                lesser = lesser.next;
            }
            else {                
                greater.next = head;
                greater = greater.next;
            }
            head = head.next;
        }
        
        greater.next = null;
        
        lesser.next = temp2.next;
        
        return temp3.next;
    }
}