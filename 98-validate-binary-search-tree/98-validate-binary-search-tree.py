class Solution:
    def recurse(self, root : Optional[TreeNode], arr : List[int]):
        if root.left != None: self.recurse(root.left, arr)
        arr.append(root.val)
        if root.right != None: self.recurse(root.right, arr)
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        arr = []
        self.recurse(root, arr)
        prev = arr[0]
        for i in range(1, len(arr)):
            if prev >= arr[i]:
                return False
            prev = arr[i]
        return True