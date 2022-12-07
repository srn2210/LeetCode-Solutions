# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def deleteDuplicates(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if head == None: return None
        if head.next and head.val == head.next.val:
            return self.deleteDuplicates(head.next)
        head.next = self.deleteDuplicates(head.next)
        return head