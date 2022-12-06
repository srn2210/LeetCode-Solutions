class Solution {
public:
    void swap(int i, int j, vector<int>& nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        return;
    }
    void backtrack(int i, vector<int>& nums, vector<vector<int>>& res) {
        if(i == nums.size()) {
            vector<int> temp;
            for(int num:nums) temp.push_back(num);
            res.push_back(temp);
            return;
        }
        else {
            for(int j=i; j<nums.size(); j++) {
                swap(i, j, nums);
                backtrack(i+1, nums, res);
                swap(i, j, nums);
            }
        }
    }
    vector<vector<int>> permute(vector<int>& nums) {
        vector<vector<int>> res;
        backtrack(0, nums, res);
        return res;
    }
};