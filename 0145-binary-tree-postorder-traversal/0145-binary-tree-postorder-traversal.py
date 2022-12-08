# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def dfs(self, node: Optional[TreeNode], ans: List[int]) -> None:
        if not node: return        
        self.dfs(node.left, ans)
        self.dfs(node.right, ans)
        ans.append(node.val)
    def postorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        ans = []
        self.dfs(root, ans)
        return ans