class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        for i in range(len(mat)):
            for j in range(len(mat[0])):
                if mat[i][j] == 1: mat[i][j] = inf
        
        for i in range(len(mat)):
            for j in range(len(mat[0])):
                if mat[i][j] == 0: continue
                t = mat[i][j]
                if j-1 >= 0: mat[i][j] = min(t, mat[i][j-1] + 1)
                if i-1 >= 0: mat[i][j] = min(mat[i][j], mat[i-1][j] + 1)
        
        for i in reversed(range(len(mat))):
            for j in reversed(range(len(mat[0]))):
                if mat[i][j] == 0: continue
                t = mat[i][j]
                if j+1 < len(mat[0]): mat[i][j] = min(t, mat[i][j+1] + 1)
                if i+1 < len(mat): mat[i][j] = min(mat[i][j], mat[i+1][j] + 1)
        
        return mat