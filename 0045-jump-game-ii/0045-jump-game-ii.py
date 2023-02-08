class Solution:
    def jump(self, nums: List[int]) -> int:
        dp = [100000 for i in range(len(nums))]
        dp[0] = 0
        for i in range(len(dp)):
            for j in range(i, min(i+nums[i]+1, len(dp))):
                dp[j] = min(dp[j], dp[i] + 1)
        return dp[-1]