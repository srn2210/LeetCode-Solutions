class Solution:
    def averageOfLevels(self, root: Optional[TreeNode]) -> List[float]:
        res = []
        
        queue = []
        queue.append(root)
        
        while queue:
            size = len(queue)
            ans = 0
            n = 0
            while size:
                node = queue.pop(0)
                if node.left != None:
                    queue.append(node.left)
                if node.right != None:
                    queue.append(node.right)
                ans += node.val
                n += 1
                size -= 1
            res.append(ans / n)
        
        return res