class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        dp = [amount+1] * (amount+1)
        dp[0] = 0
        
        for coin in coins:    
            for cash in range(amount+1):
                if(coin <= cash):
                    dp[cash] = min(dp[cash], 1 + dp[cash - coin])
        
        return -1 if dp[amount] > amount else dp[amount]