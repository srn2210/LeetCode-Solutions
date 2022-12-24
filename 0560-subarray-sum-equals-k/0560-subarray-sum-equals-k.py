class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        ref = {}
        ref[0] = 1
        total = 0
        count = 0
        for i in nums:
            total += i
            if total-k in ref:
                count += ref[total - k]
            ref[total] = ref.get(total, 0) + 1
        return count