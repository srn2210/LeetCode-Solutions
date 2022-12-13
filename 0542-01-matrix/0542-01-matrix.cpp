class Solution {
public:
    vector<vector<int>> updateMatrix(vector<vector<int>>& mat) {
        vector<vector<int>> res(mat.size(), vector<int>(mat[0].size(), INT_MAX));
        queue<pair<int, int>> queue;
        bool vis[mat.size()][mat[0].size()];
        memset(vis, false, sizeof(vis));
        for(int i=0; i<mat.size(); i++) {
            for(int j=0; j<mat[0].size(); j++) {
                if(mat[i][j] == 0) {
                    res[i][j] = 0;
                    vis[i][j] = true;
                    queue.push(make_pair(i, j));
                }
            }
        }
        int direction[4][2] = {{1,0}, {0,1}, {-1,0}, {0,-1}};
        while(!queue.empty()) {
            pair<int, int> arr = queue.front();
            queue.pop();
            for(auto dir : direction) {
                int x = dir[0] + arr.first;
                int y = dir[1] + arr.second;
                if(x < 0 || y < 0 || x >= mat.size() || y >= mat[0].size() || res[x][y] < res[arr.first][arr.second] + 1 || vis[x][y]) continue;
                else {
                    res[x][y] = 1 + res[arr.first][arr.second];
                    queue.push(make_pair(x, y));
                    if(res[arr.first][arr.second] == 0) vis[x][y];
                }
            }
        }
        return res;
    }
};