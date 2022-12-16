class Solution {
public:
    int minimumTotal(vector<vector<int>>& triangle) {
        int m = triangle.size();
        for(int i=1; i<m; i++) {
            for(int j=0; j<triangle[i].size(); j++) {
                int a = j < triangle[i-1].size() ? triangle[i-1][j] : INT_MAX;
                int b = j > 0 ? triangle[i-1][j-1] : INT_MAX;
                triangle[i][j] += min(a, b);
            }
        }
        int ans = INT_MAX;
        for(int i : triangle[m-1])
            ans = min(ans, i);
        return ans;
    }
};