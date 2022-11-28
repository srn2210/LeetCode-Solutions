class Solution:
    directions = [[1,0], [0,1], [-1,0], [0,-1]]
    def dfs(self, board: List[List[str]], word: str, i: int, j: int, s: int, vis: List[List[bool]]) -> bool:
        if s == len(word) - 1 : return True
        vis[i][j] = True
        for dir in self.directions :
            x = i + dir[0]
            y = j + dir[1]
            if x < 0 or y < 0 or x >= len(board) or y >= len(board[0]) or board[x][y] != word[s+1] or vis[x][y] : continue
            else :
                if self.dfs(board, word, x, y, s+1, vis) : return True
        vis[i][j] = False
        return False
    def exist(self, board: List[List[str]], word: str) -> bool:
        if len(word) > (len(board) * len(board[0])) : return False
        vis = [[False for j in range(len(board[0]))] for i in range(len(board))]
        for i in range(len(board)) :
            for j in range(len(board[0])) :
                if board[i][j] == word[0] :
                    if self.dfs(board, word, i, j, 0, vis) : return True
        return False