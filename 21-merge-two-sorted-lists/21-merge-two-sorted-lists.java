class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode list = new ListNode(0);
        ListNode head = list;
        
        while(list1 != null && list2 != null) {
            if(list1.val < list2.val) {
                list.next = new ListNode();
                list = list.next;
                list.val = list1.val;
                list1 = list1.next;
            }
            else if(list2.val < list1.val) {
                list.next = new ListNode();
                list = list.next;
                list.val = list2.val;
                list2 = list2.next;
            }
            else {
                list.next = new ListNode();
                list = list.next;
                list.val = list1.val;
                list1 = list1.next;
            }
        }
        if(list1 != null) {
            while(list1 != null) {
                list.next = new ListNode();
                list = list.next;
                list.val = list1.val;
                list1 = list1.next;
            }
        }
        else if(list2 != null) {
            while(list2 != null) {
                list.next = new ListNode();
                list = list.next;
                list.val = list2.val;
                list2 = list2.next;
            }
        }
        
        return head.next;
        
    }
}