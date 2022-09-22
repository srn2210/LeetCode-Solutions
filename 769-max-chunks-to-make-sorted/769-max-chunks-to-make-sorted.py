class Solution:
    def maxChunksToSorted(self, arr: List[int]) -> int:
        res = -1
        ans = 0
        for i in range(0, len(arr)):
            res = max(res, arr[i])
            if res == i:
                ans += 1
        return ans