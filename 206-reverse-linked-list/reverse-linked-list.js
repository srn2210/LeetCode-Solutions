/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @return {ListNode}
 */
var reverseList = function(head) {
    if(head === null) return head;
    let newHead = null;

    function reverse(node) {
        if(node.next === null) {
            newHead = node;
            return node;
        }
        let next = reverse(node.next);
        next.next = node;
        node.next = null;
        return node;
    }

    reverse(head);
    return newHead;
};