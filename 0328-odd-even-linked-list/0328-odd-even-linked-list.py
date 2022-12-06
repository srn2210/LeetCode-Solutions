# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def oddEvenList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        curr = head
        odd = ListNode(0)
        oddHead = odd
        even = ListNode(0)
        evenHead = even
        flag = True
        while curr:
            if flag:
                odd.next = curr
                odd = odd.next
            else:
                even.next = curr
                even = even.next
            curr = curr.next
            flag = not flag
        oddHead = oddHead.next
        evenHead = evenHead.next
        odd.next = evenHead
        even.next = None
        return oddHead