class Solution {
public:
    int maxProduct(vector<int>& nums) {
        int maxp = 1;
        int minp = 1;
        int ans = INT_MIN;
        for(int i=0; i<nums.size(); i++) {
            int temp = maxp;
            maxp = max(nums[i], nums[i] >=0 ? maxp * nums[i] : minp * nums[i]);
            minp = min(nums[i], nums[i] >=0 ? minp * nums[i] : temp * nums[i]);
            ans = max(maxp, ans);
        }
        return ans;
    }
};