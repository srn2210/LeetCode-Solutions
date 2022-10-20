class Solution:
    def maxProduct(self, nums: List[int]) -> int:
        maxp = 1
        minp = 1
        ans = -11
        for i in range(len(nums)):
            temp = maxp
            maxp = max(maxp * nums[i], minp * nums[i])
            maxp = max(maxp, nums[i])
            minp = min(temp * nums[i], minp * nums[i])
            minp = min(minp, nums[i])
            ans = max(maxp, ans)
        return ans