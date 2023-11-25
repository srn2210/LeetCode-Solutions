class Solution:
    def getSumAbsoluteDifferences(self, nums: List[int]) -> List[int]:
        post, pre, n = sum(nums), 0, len(nums)
        ans = []

        for i in range(n):
            post -= nums[i]
            left = (nums[i] * i) - pre
            right = post - (nums[i] * (n-i-1))
            ans.append(left + right)
            pre += nums[i]
        
        return ans