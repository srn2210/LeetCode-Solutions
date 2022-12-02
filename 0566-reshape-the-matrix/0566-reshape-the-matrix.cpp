class Solution {
public:
    vector<vector<int>> matrixReshape(vector<vector<int>>& mat, int r, int c) {
        if((mat.size() * mat[0].size()) != r * c) return mat;
        vector<vector<int>> res(r, vector<int>(c));
        int m = 0, n = 0;
        for(int i=0; i<mat.size(); i++) {
            for(int j=0; j<mat[0].size(); j++) {
                if(n == c) {
                    m += 1;
                    n = 0;
                }
                res[m][n++] = mat[i][j];
            }
        }
        return res;
    }
};