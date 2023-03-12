class Solution:
    def merge(self, lists: List[Optional[ListNode]], l: int, r: int) -> Optional[ListNode]:
        if l==r: return lists[l]
        if l > r: return None
        mid = (l + r) // 2
        left = self.merge(lists, l, mid)
        right = self.merge(lists, mid+1, r)
        start = ListNode(-1)
        dummy = start
        while left != None and right != None:
            if left.val <= right.val:
                dummy.next = left
                left = left.next
                dummy = dummy.next
            else:
                dummy.next = right
                right = right.next
                dummy = dummy.next
        if left != None:
            dummy.next = left
        if right != None:
            dummy.next = right 
        return start.next
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        return self.merge(lists, 0, len(lists)-1)