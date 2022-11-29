class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        ans = -inf
        curr = 0
        for num in nums :
            curr += num
            ans = max(curr, ans)
            if curr < 0 : curr = 0
        return ans
        