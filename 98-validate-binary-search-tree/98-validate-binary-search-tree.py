class Solution:
    def recurse(self, root : Optional[TreeNode], arr : List[int]):
        if root.left != None: self.recurse(root.left, arr)
        arr.append(root.val)
        if root.right != None: self.recurse(root.right, arr)
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        arr = []
        self.recurse(root, arr)
        for i in range(1, len(arr)):
            if arr[i-1] >= arr[i]:
                return False
        return True