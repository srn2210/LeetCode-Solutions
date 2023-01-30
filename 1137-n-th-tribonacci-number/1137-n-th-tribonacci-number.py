class Solution:
    def solve(self, n: int, dp: List[int]) -> int:
        if n == 0: return 0
        elif n == 1: return 1
        elif n == 2: return 1
        elif dp[n] != -1: return dp[n]
        dp[n] = self.solve(n-1, dp) + self.solve(n-2, dp) + self.solve(n-3, dp)
        return dp[n]
    def tribonacci(self, n: int) -> int:
        dp = [-1 for i in range(n+1)]
        return self.solve(n, dp)