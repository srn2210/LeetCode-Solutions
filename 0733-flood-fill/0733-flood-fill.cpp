class Solution {
public:
    int directions[4][2] = {{1,0}, {0,1}, {-1,0}, {0,-1}};
    vector<vector<int>> floodFill(vector<vector<int>>& image, int sr, int sc, int color) {
        if(image[sr][sc] == color) return image;
        queue<array<int, 2>> queue;
        queue.push({sr, sc});
        int init = image[sr][sc];
        image[sr][sc] = color;
        while(!queue.empty()) {
            int size = queue.size();
            while(size--) {
                auto arr = queue.front();
                queue.pop();
                for(auto dir : directions) {
                    int x = dir[0] + arr[0];
                    int y = dir[1] + arr[1];
                    if(x < 0 || x >= image.size() || y < 0 || y >= image[0].size() || image[x][y] != init) continue;
                    else {
                        image[x][y] = color;
                        queue.push({x,y});
                    }
                }
            }
        }
        return image;
    }
};