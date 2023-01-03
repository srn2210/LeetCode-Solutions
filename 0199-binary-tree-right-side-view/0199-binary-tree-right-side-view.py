# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        res = []
        q = deque()
        if root: q.append(root)
        while q:
            sz = len(q)
            while sz:
                temp = q.popleft()
                if temp.left: q.append(temp.left)
                if temp.right: q.append(temp.right)
                if sz == 1: res.append(temp.val)
                sz -= 1
        return res