class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        book = set(wordDict)
        #for word in wordDict: book.add(word)
        dp = [False for i in range(len(s))]
        for i in range(len(s)):
            for j in range(i, len(s)):
                if dp[j]: continue
                t = s[i:j+1]
                if t in book:
                    if j-i >= 0 and dp[i-1]: dp[j] = True
                    elif i == 0: dp[j] = True
        return dp[len(s)-1]