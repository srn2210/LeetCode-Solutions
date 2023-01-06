class Solution:
    def maxIceCream(self, costs: List[int], coins: int) -> int:
        m = max(costs)
        freq = [0 for i in range(m+1)]
        for cost in costs:
            freq[cost] += 1
        ans = 0
        for i in range(m+1):
            if coins >= i * freq[i]:
                coins -= i * freq[i]
                ans += freq[i]
            elif coins >= i:
                ans += coins // i
                coins -= (coins // i) * i
            else: break
        return ans