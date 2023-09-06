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
    public ListNode[] splitListToParts(ListNode head, int k) {
        int len = 0;
        var dummy = head;
        while(dummy != null) {
            dummy = dummy.next;
            len++;
        }
        ListNode[] ans = new ListNode[k];
        int compSize = len / k;
        int extra = len % k;
        dummy = head;
        for(int i=0; i<k; i++) {
            int count = compSize + (extra > 0 ? 1 : 0);
            extra--;
            if(dummy == null) continue;
            var start = dummy;
            while(count-- > 1) {
                dummy = dummy.next;
            }
            var next = dummy.next;
            dummy.next = null;
            dummy = next;
            ans[i] = start;
        }
        return ans;
    }
}