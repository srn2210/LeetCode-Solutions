class Solution:
    def countGoodStrings(self, low, high, zero, one):
        mod = int(1e9) + 7
        dp = [-1] * (high + 1)
        return (self.solve(low, high, zero, one, 0, dp) // 2) % mod

    def solve(self, low, high, zero, one, curr, dp):
        if curr > high:
            return 0
        if dp[curr] != -1:
            return dp[curr]
        ans, t = 0, 0
        if curr >= low:
            t = 2
        ans = t + self.solve(low, high, zero, one, curr + zero, dp) + self.solve(low, high, zero, one, curr + one, dp)
        dp[curr] = ans
        return dp[curr]
