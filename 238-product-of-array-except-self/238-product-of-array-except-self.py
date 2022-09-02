class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        right = [1] * len(nums)
        
        for i in reversed(range(len(nums) - 1)):
            right[i] = right[i+1] * nums[i+1]
        
        left = 1
        
        for i in range(len(nums)):
            right[i] = left * right[i]
            left = left * nums[i]
            
        return right