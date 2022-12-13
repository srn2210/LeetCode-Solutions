class Solution {
public:
    int minFallingPathSum(vector<vector<int>>& matrix) {
        for(int i=1; i<matrix.size(); i++) {
            for(int j=0; j<matrix[0].size(); j++) {
                int t = matrix[i][j];
                matrix[i][j] = matrix[i][j] + matrix[i-1][j];
                if(j - 1 >= 0) matrix[i][j] = min(matrix[i][j], matrix[i-1][j-1] + t);
                if(j + 1 < matrix[0].size()) matrix[i][j] = min(matrix[i][j], matrix[i-1][j+1] + t);
            }
        }
        int ans = INT_MAX;
        for(int i=0; i<matrix[0].size(); i++) {
            ans = min(ans, matrix[matrix.size()-1][i]);
        }
        return ans;
    }
};