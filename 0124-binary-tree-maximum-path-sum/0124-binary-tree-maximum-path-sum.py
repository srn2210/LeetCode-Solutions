# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    ans = -inf
    def dfs(self, node: Optional[TreeNode]) -> int:
        if not node: return 0
        curr = node.val
        left = self.dfs(node.left)
        right = self.dfs(node.right)
        locmax = max(curr, curr + left)
        locmax = max(locmax, curr + right)
        self.ans = max(locmax, self.ans)
        self.ans = max(self.ans, curr + left + right)
        return locmax
    def maxPathSum(self, root: Optional[TreeNode]) -> int:
        self.dfs(root)
        return self.ans