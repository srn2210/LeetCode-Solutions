# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def find(self, root: Optional[TreeNode], node: Optional[TreeNode], target: int) -> bool:
        if not root: return False
        if root.val < target: return self.find(root.right, node, target)
        if root.val > target: return self.find(root.left, node, target)
        if root == node: return False
        if root.val == target: return True
        return False
    def dfs(self, root: Optional[TreeNode], node: Optional[TreeNode], target: int) -> bool:
        if not node: return False
        if self.dfs(root, node.left, target): return True
        if self.dfs(root, node.right, target): return True
        if self.find(root, node, target - node.val): return True
        return False
    def findTarget(self, root: Optional[TreeNode], k: int) -> bool:
        return self.dfs(root, root, k)