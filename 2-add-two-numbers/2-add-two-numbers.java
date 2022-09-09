class Solution {
    int add(ListNode a, ListNode b, int carry) {
        int val1 = 0;
        int val2 = 0;
        if(a != null) {
            val1 = a.val;
        }
        if(b != null) {
            val2 = b.val;
        }
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
            if(temp > 9) {
                prev = temp / 10;
                temp = temp % 10;
            }
            else {
                prev = 0;
            }
            n.val = temp;
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }
        return l3.next;
    }
}