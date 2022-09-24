class Solution:
    def concatenatedBinary(self, n: int) -> int:
        bits = 0
        ans = 0
        for i in range(1, n+1):
            if i & i-1 == 0:
                bits += 1
            ans = ((ans << bits) | i) % 1000000007
        return ans