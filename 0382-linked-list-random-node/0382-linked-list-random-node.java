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
    Map<Integer, ListNode> map;
    int size;
    Random obj;
    public Solution(ListNode head) {
        map = new HashMap<>();
        size = -1;
        var temp = head;
        obj = new Random();
        while(temp != null) {
            var t = temp;
            temp = temp.next;
            size++;
            map.put(size, t);
        }
    }
    
    public int getRandom() {
        return map.get((obj.nextInt(size+1))).val;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */