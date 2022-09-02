class Solution:
    def solve(self, i: int, j: int, a: str, b: str, dp: List[List[int]]) -> int:
        ans = 0
        if(i == len(a) or j == len(b)):
            return 0
        elif dp[i][j] != -1:
            return dp[i][j]
        elif a[i] == b[j]:
            dp[i][j] = 1 + self.solve(i+1, j+1, a, b, dp)
            ans = max(dp[i][j], ans)
        else:
            dp[i][j] = max(self.solve(i+1, j, a, b, dp), self.solve(i, j+1, a, b, dp))
            ans = max(dp[i][j], ans)
        return ans
    def longestCommonSubsequence(self, text1: str, text2: str) -> int:
        dp = [[-1 for i in range(len(text2))] for j in range(len(text1))]
        return self.solve(0, 0, text1, text2, dp)