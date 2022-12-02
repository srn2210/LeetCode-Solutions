class Solution:
    def matrixReshape(self, mat: List[List[int]], r: int, c: int) -> List[List[int]]:
        if len(mat) * len(mat[0]) != r * c : return mat
        res = [[0 for j in range(c)] for i in range(r)]
        m = 0
        n = 0
        for i in range(len(mat)) :
            for j in range(len(mat[0])) :
                if n == c :
                    m += 1
                    n = 0
                res[m][n] = mat[i][j]
                n += 1
        return res