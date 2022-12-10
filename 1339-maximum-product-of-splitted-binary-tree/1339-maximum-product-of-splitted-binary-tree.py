# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    total = 0
    ans = 0
    def dfs(self, node: Optional[TreeNode]) -> int:
        if not node: return 0
        s = self.dfs(node.left) + node.val + self.dfs(node.right)
        self.ans = max(self.ans, s * (self.total - s))
        return s
    def maxProduct(self, root: Optional[TreeNode]) -> int:
        self.total = self.dfs(root)
        self.dfs(root)
        return self.ans % 1000000007