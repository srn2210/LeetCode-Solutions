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
    public ListNode mergeKLists(ListNode[] lists) {
        Queue<ListNode> queue = new PriorityQueue<>((a,b) -> Integer.compare(a.val, b.val));
        ListNode dummy = new ListNode(0);
        var head = dummy;
        for(var list : lists) if(list != null) queue.offer(list);
        while(!queue.isEmpty()) {
            var list = queue.poll();
            dummy.next = list;
            dummy = dummy.next;
            if(list.next != null) queue.offer(list.next);
        }
        return head.next;
    }
}