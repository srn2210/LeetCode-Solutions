class Solution:
    def reductionOperations(self, nums: List[int]) -> int:
        ans = 0
        maxi = max(nums)
        buckets = [0 for i in range(maxi+1)]

        for num in nums:
            buckets[num] = buckets[num] + 1
        
        curr = buckets[maxi]

        for num in range(maxi-1, -1, -1):
            if buckets[num]:
                ans += curr
                curr += buckets[num]

        return ans