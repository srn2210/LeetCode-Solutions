# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def dfs(self, node: Optional[TreeNode], lo: int, hi: int) -> int:
        if not node: return abs(hi - lo)
        lo = min(lo, node.val)
        hi = max(hi, node.val)
        return max(self.dfs(node.left, lo, hi), self.dfs(node.right, lo, hi))
    def maxAncestorDiff(self, root: Optional[TreeNode]) -> int:
        return self.dfs(root, inf, -inf)