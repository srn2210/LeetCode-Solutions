class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        k = k % len(nums)
        arr = [0] * k
        j = 0
        for i in range(len(nums)-k, len(nums)):
            arr[j] = nums[i]
            j += 1
        for i in reversed(range(len(nums)-k)):
            nums[i+k] = nums[i]
        for i in range(k):
            nums[i] = arr[i]