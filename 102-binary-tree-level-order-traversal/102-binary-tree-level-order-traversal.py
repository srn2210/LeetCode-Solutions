# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if(root == None): return []
        
        res = []
        
        queue = deque()
        
        queue.append(root)
        
        while queue:
            size = len(queue)
            lis = []
            while size:
                temp = queue.popleft()
                lis.append(temp.val)
                if(temp.left != None):
                    queue.append(temp.left)
                if(temp.right != None):
                    queue.append(temp.right)
                size -= 1
            res.append(lis)
        
        return res