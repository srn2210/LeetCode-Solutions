class Solution:
    def minSubArrayLen(self, target: int, nums: List[int]) -> int:
        ans = len(nums) + 1
        i=0
        j=0
        while(i<len(nums)):
            target -= nums[i]
            while(target <= 0):
                ans = min(ans, i-j+1)
                target += nums[j]
                j += 1
            i += 1
        if ans < len(nums) + 1:
            return ans
        else: return 0