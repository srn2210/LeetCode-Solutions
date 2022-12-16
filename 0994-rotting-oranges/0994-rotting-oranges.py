class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        directions = [[1,0], [0,1], [-1,0], [0,-1]]
        q = deque()
        for i in range(len(grid)):
            for j in range(len(grid[i])):
                if grid[i][j] == 2:
                    q.append([i,j])
        ans = -1
        while q:
            size = len(q)
            ans += 1
            while size:
                node = q.popleft()
                for dir in directions:
                    x = node[0] + dir[0]
                    y = node[1] + dir[1]
                    if x < 0 or y < 0 or x >= len(grid) or y >= len(grid[0]) or grid[x][y] != 1: continue
                    else:
                        grid[x][y] = 2
                        q.append([x,y])
                size -= 1
        
        for i in grid:
            for j in i:
                if j == 1: return -1
        
        return ans if ans != -1 else 0