class Solution {
public:
    int minSubArrayLen(int target, vector<int>& nums) {
        int len = nums.size();
        int ans = len + 1;
        int i=0,j=0;
        while(i<len) {
            target -= nums[i];
            while(target <= 0) {
                ans = min(ans, i-j+1);
                target += nums[j];
                j++;
            }
            i++;
        }
        return ans == len + 1 ? 0 : ans;
    }
};