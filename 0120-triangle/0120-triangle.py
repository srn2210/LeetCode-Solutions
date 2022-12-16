class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        for i in range(1, len(triangle)):
            for j in range(len(triangle[i])):
                a = triangle[i-1][j] if j < len(triangle[i-1]) else inf
                b = triangle[i-1][j-1] if j > 0 else inf
                triangle[i][j] += min(a, b)
        ans = inf
        for i in triangle[len(triangle)-1]:
            ans = min(ans, i)
        return ans