class Solution:
    def maxFrequency(self, nums: List[int], k: int) -> int:
        nums.sort()
        ans, left, right = 1, 0, 0
        diff = 0
        pref = []

        pref.append(nums[0])

        for i in range(1, len(nums)):
            pref.append(pref[i-1] + nums[i])

        while left <= right and right < len(nums):
            s = pref[right] - pref[left] + nums[left]
            l = right - left + 1
            t = l * nums[right]

            diff = t - s

            if diff <= k:
                ans = max(ans, l)
                right += 1
            else:
                left += 1

        return ans