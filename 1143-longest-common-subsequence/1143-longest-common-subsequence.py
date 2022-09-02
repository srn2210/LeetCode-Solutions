class Solution:
    def longestCommonSubsequence(self, text1: str, text2: str) -> int:
        if(len(text2) > len(text1)):
            return self.longestCommonSubsequence(text2, text1)
        dp = [[0 for i in range(len(text2)+1)] for j in range(len(text1)+1)]
        ans = 0
        for i,c in enumerate(text1):
            for j,d in enumerate(text2):
                if(c == d):
                    dp[i][j] = 1 + dp[i-1][j-1]
                    ans = max(ans, dp[i][j])
                else:
                    dp[i][j] = max(dp[i-1][j], dp[i][j-1])
                    ans = max(ans, dp[i][j])
        return ans