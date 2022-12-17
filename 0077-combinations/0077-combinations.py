class Solution:
    def backtrack(self, n: int, k: int, res: List[List[int]], arr: List[int], i: int) -> None:
        if len(arr) == k:
            res.append(arr.copy())
            return
        else:
            for j in range(i, n):
                arr.append(j)
                self.backtrack(n, k, res, arr, j + 1)
                arr.pop()
    def combine(self, n: int, k: int) -> List[List[int]]:
        res = []
        arr = []
        self.backtrack(n+1, k, res, arr, 1)
        return res