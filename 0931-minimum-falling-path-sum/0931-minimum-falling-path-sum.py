class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        for i in range(1, len(matrix)):
            for j in range(len(matrix[0])):
                t = matrix[i][j]
                matrix[i][j] = t + matrix[i-1][j]
                if j - 1 >= 0: matrix[i][j] = min(matrix[i][j], matrix[i-1][j-1] + t)
                if j + 1 < len(matrix[0]): matrix[i][j] = min(matrix[i][j], matrix[i-1][j+1] + t)
        ans = inf
        for i in range(len(matrix[0])):
            ans = min(ans, matrix[len(matrix)-1][i])
        return ans