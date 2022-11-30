class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        map = dict()
        for cnt, num in enumerate(nums):
            t = target - num
            if t in map:
                return {cnt, map[t]}
            map[num] = cnt
            