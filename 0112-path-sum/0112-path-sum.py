# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def dfs(self, node: Optional[TreeNode], target: int, ans: int) -> bool:
        if not node: return False
        if not node.left and not node.right and ans + node.val == target: return True
        return self.dfs(node.left, target, ans + node.val) or self.dfs(node.right, target, ans + node.val)
    def hasPathSum(self, root: Optional[TreeNode], targetSum: int) -> bool:
        return self.dfs(root, targetSum, 0)