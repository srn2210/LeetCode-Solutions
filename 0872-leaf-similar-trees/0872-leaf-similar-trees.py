# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    s1 = []
    s2 = []
    def dfs(self, node: Optional[TreeNode], flag: bool) -> None:
        if not node: return
        if not node.left and not node.right:
            if flag:
                self.s1.append(node.val)
                return
            else:
                self.s2.append(node.val)
                return
        self.dfs(node.left, flag)
        self.dfs(node.right, flag)
        return
    def leafSimilar(self, root1: Optional[TreeNode], root2: Optional[TreeNode]) -> bool:
        s1 = []
        s2 = []
        self.s1 = s1
        self.s2 = s2
        self.dfs(root1, True)
        self.dfs(root2, False)
        if len(s1) != len(s2): return False
        for i in range(len(s1)):
            if s1[i] != s2[i]: return False
        return True