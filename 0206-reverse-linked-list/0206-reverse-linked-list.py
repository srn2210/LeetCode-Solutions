# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    ans = None
    def helper(self, node: Optional[ListNode]) -> Optional[ListNode]:
        if node.next == None:
            self.ans = node
            return node
        curr = self.helper(node.next)
        curr.next = node
        node.next = None
        return node
    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if head == None: return None
        self.helper(head)
        return self.ans