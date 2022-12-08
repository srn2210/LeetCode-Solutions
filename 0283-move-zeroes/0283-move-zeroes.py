class Solution:
    def moveZeroes(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        j = 0
        for i in range(len(nums)):
            if nums[j] == 0 and nums[i] != 0:
                nums[i], nums[j] = nums[j], nums[i]
                j += 1
            elif nums[j] != 0:
                j += 1