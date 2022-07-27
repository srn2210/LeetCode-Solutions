class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null){return head;}
        ListNode t = head;
        ListNode prev = new ListNode();
        ListNode s = prev;
        while(t != null){
         if(t.next == null){
            prev.next = new ListNode();
            prev = prev.next;
            prev.val = t.val;
            return s.next;
        }
        if( t != null && t.val != t.next.val){
            prev.next = new ListNode();
            prev = prev.next;
            prev.val = t.val;
            t = t.next;
        }
        if(t.next != null && t.val == t.next.val){
            int temp = t.val;
            while(t != null && t.val == temp){
                t = t.next;
            }
        }   
        }
        return s.next;
    }
}