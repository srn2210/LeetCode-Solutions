class Solution:
    def dfs(self, node: Optional[TreeNode], arr: List[int]) -> None:
        if not node: return
        if not node.left and not node.right:
            arr.append(node.val)
        self.dfs(node.left, arr)
        self.dfs(node.right, arr)
        return
    def leafSimilar(self, root1: Optional[TreeNode], root2: Optional[TreeNode]) -> bool:
        s1 = []
        s2 = []
        self.dfs(root1, s1)
        self.dfs(root2, s2)
        if len(s1) != len(s2): return False
        for i in range(len(s1)):
            if s1[i] != s2[i]: return False
        return True