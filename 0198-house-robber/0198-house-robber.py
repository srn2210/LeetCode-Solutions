class Solution:
    def helper(self, nums: List[int], dp: List[int], index: int) -> int:
        if index == 0:
            dp[index] = nums[index]
            return dp[index]
        if index == 1:
            dp[index] = max(nums[0], nums[1])
            return dp[index]
        if dp[index] != -1: return dp[index]
        dp[index] = max(self.helper(nums, dp, index-1), nums[index] + self.helper(nums, dp, index-2))
        return dp[index]        
    def rob(self, nums: List[int]) -> int:
        dp = [-1 for i in range(len(nums))]
        return self.helper(nums, dp, len(nums)-1)