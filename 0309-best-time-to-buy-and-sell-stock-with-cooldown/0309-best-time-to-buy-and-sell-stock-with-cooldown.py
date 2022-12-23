class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        n = len(prices)
        if n == 1: return 0
        buy = [0 for i in range(n)]
        sell = [0 for i in range(n)]
        buy[0] = -prices[0]
        buy[1] = max(buy[0], -prices[1])
        sell[1] = max(sell[0], prices[1] + buy[0])
        for i in range(2, n):
            buy[i] = max(buy[i-1], sell[i-2] - prices[i])
            sell[i] = max(sell[i-1], prices[i] + buy[i-1])
        return max(buy[n-1], sell[n-1])