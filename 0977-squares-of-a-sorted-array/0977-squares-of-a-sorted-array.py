class Solution:
    def binarySearch(self, nums: List[int], target: int) -> int:
        lo = 0
        hi = len(nums) - 1
        while lo <= hi:
            mid = lo + (hi-lo) // 2
            if nums[mid] == target: return mid
            elif nums[mid] < target: lo = mid + 1
            else: hi = mid - 1
        return lo
    def sortedSquares(self, nums: List[int]) -> List[int]:
        res = [0 for i in range(len(nums))]
        right = self.binarySearch(nums, 0)
        left = right - 1
        i = 0
        while left >= 0 or right < len(nums):
            if left < 0:
                res[i] = nums[right] * nums[right]
                i += 1
                right += 1
            elif right >= len(nums):
                res[i] = nums[left] * nums[left]
                i += 1
                left -= 1
            elif nums[right] < -nums[left]:
                res[i] = nums[right] * nums[right]
                i += 1
                right += 1
            else:
                res[i] = nums[left] * nums[left]
                i += 1
                left -= 1
        return res