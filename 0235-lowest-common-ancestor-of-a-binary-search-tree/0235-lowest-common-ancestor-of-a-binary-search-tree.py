# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def dfs(self, node: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if not node: return None
        if p.val >= node.val and q.val <= node.val: return node
        if q.val >= node.val and p.val <= node.val: return node
        left = self.dfs(node.left, p, q)
        right = self.dfs(node.right, p, q)
        return left if not left == None else right
        
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        return self.dfs(root, p, q)