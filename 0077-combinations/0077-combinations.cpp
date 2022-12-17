class Solution {
public:
    void backtrack(int n, int k, vector<vector<int>>& res, vector<int>& arr, int i) {
        if(arr.size() == k) {
            res.push_back(arr);
            return;
        }
        else {
            for(int j=i; j<=n; j++) {
                arr.push_back(j);
                backtrack(n, k, res, arr, j+1);
                arr.pop_back();
            }
        }
    }
    vector<vector<int>> combine(int n, int k) {
        vector<vector<int>> res;
        vector<int> arr;
        backtrack(n, k, res, arr, 1);
        return res;
    }
};