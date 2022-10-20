class Solution {
public:
    vector<vector<int>> directions = {{1,0}, {0,1}, {-1,0}, {0,-1}};
    void bfs(int i, int j, vector<vector<char>> &grid, vector<vector<bool>> &vis) {
        queue<vector<int>> q;
        q.push({i,j});
        vis[i][j] = true;
        while(q.size() > 0) {
            vector<int> temp = q.front();
            q.pop();
            for(int i=0; i<directions.size(); i++) {
                int x = directions[i][0] + temp[0];
                int y = directions[i][1] + temp[1];
                if(x < grid.size() && x >= 0 && y >= 0 && y < grid[0].size() && !vis[x][y] && grid[x][y] == '1') {
                    vis[x][y] = true;
                    q.push({x, y});
                }
            }
        }
    }
    int numIslands(vector<vector<char>>& grid) {
        vector<vector<bool>> vis (grid.size(), vector<bool>(grid[0].size(), false));
        int ans = 0;
        for(int i=0; i<grid.size(); i++) {
            for(int j=0; j<grid[i].size(); j++) {
                if(!vis[i][j] && grid[i][j] == '1') {
                    ans++;
                    bfs(i, j, grid, vis);
                }
            }
        }
        return ans;
    }
};