# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
        dummy = ListNode(0)
        dummy.next = head
        fast = dummy
        slow = dummy
        cnt = 0
        while fast.next:
            fast = fast.next
            cnt += 1
            if cnt > n: slow = slow.next
        slow.next = slow.next.next
        return dummy.next