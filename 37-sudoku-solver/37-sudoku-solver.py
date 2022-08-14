class Solution:
    def valid(self, row: int, col: int, n: str, board: List[List[str]]) -> bool:
        for i in range(0,9):
            if board[i][col] == n:
                return False
        for j in range(0,9):
            if board[row][j] == n:
                return False
        
        x = (row // 3) * 3
        y = (col // 3) * 3
        
        for i in range(x,x+3):
            for j in range(y,y+3):
                if i == row or j == col:
                    continue
                elif(board[i][j] == n):
                    return False
        
        return True
    def solve(self, board: List[List[str]]) -> bool:
        default = ["1","2","3","4","5","6","7","8","9"]
        
        for i in range(0,9):
            for j in range(0,9):
                if board[i][j] == ".":
                    for c in default:
                        if self.valid(i, j, c, board):
                            board[i][j] = c
                            if self.solve(board): 
                                return True
                            board[i][j] = "."
                    return False
                
        return True
    def solveSudoku(self, board: List[List[str]]) -> None:
        self.solve(board)