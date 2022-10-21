class Solution:
    def canJump(self, nums: List[int]) -> bool:
        l = len(nums)
        dp = [False] * l
        dp[l-1] = True
        last = l-1
        i = last-1
        
        while i >= 0:
            if nums[i] >= last-i:
                dp[i] = True
                last = i
            i -= 1
        return dp[0]