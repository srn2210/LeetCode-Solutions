# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def dfs(self, node: Optional[TreeNode]) -> None:
        if not node: return
        temp = node.left
        node.left = node.right
        node.right = temp
        self.dfs(node.left)
        self.dfs(node.right)
    def invertTree(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        self.dfs(root)
        return root