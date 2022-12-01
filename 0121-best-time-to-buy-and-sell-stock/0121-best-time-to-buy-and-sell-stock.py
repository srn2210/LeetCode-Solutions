class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        ans = 0
        m = inf
        for price in prices:
            ans = max(ans, price - m)
            m = min(m, price)
        return ans