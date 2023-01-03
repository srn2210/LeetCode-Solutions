class Solution:
    def spiralOrder(self, matrix: List[List[int]]) -> List[int]:
        res = []
        m = 0
        n = 0
        for i in range(min(math.ceil(len(matrix)/2), math.ceil(len(matrix[0])/2))):
            
            for j in range(n, len(matrix[0])-n):
                res.append(matrix[m][j])
            
            for j in range(m+1, len(matrix)-m):
                res.append(matrix[j][len(matrix[0])-n-1])
            
            if m != len(matrix)-m-1:
                for j in reversed(range(n, len(matrix[0])-n-1)):
                    res.append(matrix[len(matrix)-m-1][j])
            
            if n != len(matrix[0])-n-1:
                for j in reversed(range(m+1, len(matrix)-m-1)):
                    res.append(matrix[j][n])
                
            m += 1
            n += 1
                
        return res