class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head.next == null) return head;
        if(left == right) return head;
        ListNode temp1 = head;
        ListNode temp2 = head;
        ListNode prev = head;
        ListNode next = head;
        
        int count = 0;
        
        
        while(count < left-1 && temp1 != null) {
            prev = temp1;
            temp1 = temp1.next;
            count++;
        }
        
        
        ListNode first = temp1;
        temp2 = temp1.next;
        
        
        while(count < right-1) {
            next = temp2.next;
            temp2.next = temp1;
            temp1 = temp2;
            temp2 = next;
            count++;
        }
        
        prev.next = temp1;
        first.next = next;
        
        if(left == 1) head = temp1;
        
        
        return head;
        
    }
}