class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        m = len(mat)
        n = len(mat[0])
        for i in range(m):
            for j in range(n):
                if mat[i][j] == 1: mat[i][j] = inf
        
        for i in range(m):
            for j in range(n):
                if mat[i][j] == 0: continue
                if j-1 >= 0: mat[i][j] = min(mat[i][j], mat[i][j-1] + 1)
                if i-1 >= 0: mat[i][j] = min(mat[i][j], mat[i-1][j] + 1)
        
        for i in reversed(range(m)):
            for j in reversed(range(n)):
                if mat[i][j] == 0: continue
                if j+1 < n: mat[i][j] = min(mat[i][j], mat[i][j+1] + 1)
                if i+1 < m: mat[i][j] = min(mat[i][j], mat[i+1][j] + 1)
        
        return mat