class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        k %= len(nums)
        if len(nums) == k: return
        nums[:len(nums)-k] = nums[len(nums)-k-1::-1]
        nums[len(nums)-k:len(nums)] = nums[len(nums):len(nums)-k-1:-1]
        nums[::] = nums[::-1]