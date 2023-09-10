class Solution:
    def countOrders(self, n: int) -> int:
        mod = int(1e9+7)
        @cache
        def solve(pick : int, deli : int) -> int:
            if pick == n and deli == 0: return 1
            ans = 0
            remPick = n - pick
            if remPick > 0:
                ans += remPick * solve(pick+1, deli+1)
            if deli > 0:
                ans += deli * solve(pick, deli-1)
            return ans % mod
        return solve(0, 0)