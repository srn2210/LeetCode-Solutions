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
    List<ListNode> map;
    Random obj;
    public Solution(ListNode head) {
        map = new ArrayList<>();
        var temp = head;
        obj = new Random();
        while(temp != null) {
            map.add(temp);
            temp = temp.next;
        }
    }
    
    public int getRandom() {
        return map.get(obj.nextInt(map.size())).val;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */