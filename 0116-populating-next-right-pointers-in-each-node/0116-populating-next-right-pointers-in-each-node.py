"""
# Definition for a Node.
class Node:
    def __init__(self, val: int = 0, left: 'Node' = None, right: 'Node' = None, next: 'Node' = None):
        self.val = val
        self.left = left
        self.right = right
        self.next = next
"""

class Solution:
    def connect(self, root: 'Optional[Node]') -> 'Optional[Node]':
        if not root: return root
        q = deque()
        q.append(root)
        while q:
            size = len(q)
            while size:
                size -= 1
                temp = q.popleft()
                if size: temp.next = q[0]
                if temp.left: q.append(temp.left)
                if temp.right: q.append(temp.right)
        return root