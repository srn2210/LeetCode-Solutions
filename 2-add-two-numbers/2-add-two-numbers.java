class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int prev = 0, temp = 0;
        ListNode l3 = new ListNode();
        ListNode n = l3;
        while(l1 != null || l2 != null || prev != 0){
            int val1 = l1 == null ? 0 : l1.val;
            int val2 = l2 == null ? 0 : l2.val;
            temp = val1 + val2 + prev;
            prev = temp / 10;
            n.next = new ListNode(temp % 10);
            n = n.next;
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }
        return l3.next;
    }
}