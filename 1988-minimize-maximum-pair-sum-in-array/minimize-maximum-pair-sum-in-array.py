class Solution:
    def minPairSum(self, nums: List[int]) -> int:
        nums.sort()
        maxi, left, right = 0, 0, len(nums)-1
        while left < right:
            maxi = max(maxi, nums[left] + nums[right])
            left += 1
            right -= 1
        return maxi