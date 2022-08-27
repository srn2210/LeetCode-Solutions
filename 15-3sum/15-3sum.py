class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        nums.sort()
        
        res = []
        
        i=0
        
        while(i < (len(nums))):
            if(nums[i] > 0): break
            l = i+1
            r = len(nums)-1
            while(l < r):
                sum = nums[i] + nums[l] + nums[r]
                
                if(sum > 0):
                    r -= 1
                elif(sum < 0):
                    l += 1
                else:
                    lis = [nums[i], nums[l], nums[r]]
                    res.append(lis)
                    while(l+1 < len(nums) and nums[l] == nums[l+1]):
                        l += 1
                    l += 1
                    r -= 1
            while(i+1 < len(nums) and nums[i] == nums[i+1]):
                i += 1
            i += 1
        
        return res