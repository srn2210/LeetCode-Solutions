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
    def dfs(self, node: 'Optional[Node]') -> 'Optional[Node]':
        if not node: return node
        if node.left: node.left.next = node.right
        if node.right and node.next: node.right.next = node.next.left
        self.dfs(node.left)
        self.dfs(node.right)
        return node
    def connect(self, root: 'Optional[Node]') -> 'Optional[Node]':
        return self.dfs(root)