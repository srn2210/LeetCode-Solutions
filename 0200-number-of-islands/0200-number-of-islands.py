class Solution:
    directions = [[1,0],[0,1],[-1,0],[0,-1]]
    def bfs(self, i: int, j: int, grid: List[List[str]]) -> None:
        q = deque()
        grid[i][j] = '0'
        q.append([i,j])
        while q:
            temp = q.popleft()
            for dir in self.directions:
                x = temp[0] + dir[0]
                y = temp[1] + dir[1]
                if x >= 0 and x < len(grid) and y >= 0 and y < len(grid[x]) and grid[x][y] == '1':
                    grid[x][y] = '0'
                    q.append([x,y])
    def numIslands(self, grid: List[List[str]]) -> int:
        ans = 0
        for i in range(len(grid)):
            for j in range(len(grid[i])):
                if grid[i][j] == '1':
                    ans += 1
                    self.bfs(i, j, grid)
        return ans