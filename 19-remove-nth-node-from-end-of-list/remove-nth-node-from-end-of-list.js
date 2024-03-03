/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @param {number} n
 * @return {ListNode}
 */
var removeNthFromEnd = function(head, n) {
    let fast = head;
    let slow = head;
    let prev = new ListNode();
    prev.next = head;
    let newHead = prev;
    while(fast.next != null) {
        fast = fast.next;
        n--;
        if(n <= 0) {
            prev = slow;
            slow = slow.next;
        }
    }
    prev.next = slow.next;
    return newHead.next;
};