class Solution {
public:
    int maxSubArray(vector<int>& nums) {
        int ans = -10001;
        int curr = 0;
        for(int num : nums) {
            curr += num;
            ans = max(ans, curr);
            if(curr < 0) curr = 0;
        }
        return ans;
    }
};