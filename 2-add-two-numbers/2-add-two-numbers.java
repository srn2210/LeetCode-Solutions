class Solution {
    int add(ListNode a, ListNode b, int carry) {
        int val1 = a == null ? 0 : a.val;
        int val2 = b == null ? 0 : b.val;
        return val1+val2+carry;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int prev=0, temp = 0;
        ListNode l3 = new ListNode();
        ListNode n = l3;
        while(l1 != null || l2 !=null || prev != 0){
            n.next = new ListNode();
            n = n.next;
            temp = add(l1, l2, prev);
            prev = temp / 10;
            temp = temp % 10;
            n.val = temp;
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }
        return l3.next;
    }
}