class Solution:
    def countOrders(self, n: int) -> int:
        if n == 0: return 1
        mod = int(1e9+7)
        return (self.countOrders(n-1) * n * (2*n-1)) % mod