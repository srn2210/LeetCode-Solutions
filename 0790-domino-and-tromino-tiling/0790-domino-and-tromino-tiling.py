class Solution:
    def solve(self, n: int, x: int, y: int, dp: List[List[int]]) -> int:
        if x > n or y > n: return 0
        if x == n and y == n: return 1
        if dp[x][y] != -1: return dp[x][y]
        ans = 0
        if x == y:
            ans += self.solve(n, x+1, y+1, dp)
            ans += self.solve(n, x+2, y+2, dp)
            ans += self.solve(n, x+2, y+1, dp)
            ans += self.solve(n, x+1, y+2, dp)
        elif x-1 == y:
            ans += self.solve(n, x+1, y+2, dp)
            ans += self.solve(n, x, y+2, dp)
        else:
            ans += self.solve(n, x+2, y+1, dp)
            ans += self.solve(n, x+2, y, dp)
        dp[x][y] = ans % int(1e9+7)
        return dp[x][y]
    def numTilings(self, n: int) -> int:
        dp = [[-1 for i in range(n+1)] for j in range(n+1)]
        return self.solve(n, 0, 0, dp)