class Solution:
    def maxSatisfaction(self, satisfaction: List[int]) -> int:
        ans = 0
        carry = 0
        prev = 0
        for s in reversed(sorted(satisfaction)):
            carry += s
            curr = carry + prev
            ans = max(ans, curr)
            prev = curr
        return ans