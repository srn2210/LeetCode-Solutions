class Solution:
    mod = int(1e9+7)

    def validate(self, pizza, startRow, endRow, startCol, endCol):
        for i in range(startRow, endRow+1):
            for j in range(startCol, endCol+1):
                if pizza[i][j] == 'A':
                    return True
        return False

    def solve(self, pizza, target, startRow, endRow, startCol, endCol, dp):
        if target == 0:
            for i in range(startRow, endRow+1):
                for j in range(startCol, endCol+1):
                    if pizza[i][j] == 'A':
                        return 1
            return 0

        if startRow > endRow or startCol > endCol:
            return 0

        if dp[startRow][startCol][target] != -1:
            return dp[startRow][startCol][target]

        sum = 0
        for i in range(startRow, endRow+1):
            if self.validate(pizza, startRow, i, startCol, endCol):
                sum += self.solve(pizza, target-1, i+1, endRow, startCol, endCol, dp)
                sum %= self.mod

        for i in range(startCol, endCol+1):
            if self.validate(pizza, startRow, endRow, startCol, i):
                sum += self.solve(pizza, target-1, startRow, endRow, i+1, endCol, dp)
                sum %= self.mod

        dp[startRow][startCol][target] = sum
        return sum

    def ways(self, pizza: List[str], k: int) -> int:
        m, n = len(pizza), len(pizza[0])
        dp = [[[-1]*k for _ in range(n)] for _ in range(m)]
        return self.solve(pizza, k-1, 0, m-1, 0, n-1, dp)
