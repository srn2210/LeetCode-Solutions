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
    public ListNode removeZeroSumSublists(ListNode head) {
        var st = new Stack<Pair<Integer, ListNode>>();
        var set = new HashSet<Integer>();
        int sum = 0;
        var curr = head;
        set.add(0);
        while(curr != null) {
            sum += curr.val;
            if(set.contains(sum)) {
                while(!st.isEmpty() && st.peek().getKey() != sum) {
                    var top = st.pop();
                    set.remove(top.getKey());
                }
            }
            else {
                set.add(sum);
                st.push(new Pair<>(sum, curr));
            }
            curr = curr.next;
        }
        ListNode ele = null;
        while(!st.isEmpty()) {
            var node = st.pop().getValue();
            node.next = ele;
            ele = node;
        }
        return ele;
    }
}