class Solution:
    def minimumAverageDifference(self, nums: List[int]) -> int:
        asum = 0
        for num in nums: asum += num
        curr = 0
        ans = inf
        res = 0
        for i in range(len(nums)):
            curr += nums[i]
            a = (curr//(i+1))
            b = 0
            if i != len(nums)-1:
                b = (asum-curr)//(len(nums)-i-1)
            temp = abs(a - b)
            if temp < ans:
                ans = temp
                res = i
        return res