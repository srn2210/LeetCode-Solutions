class Solution:
    def maxSatisfaction(self, satisfaction: List[int]) -> int:
        ans = 0
        carry = 0
        prev = 0
        for s in reversed(sorted(satisfaction)):
            carry += s
            ans = max(ans, carry + prev)
            prev = carry + prev
        return ans