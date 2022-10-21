class Solution {
public:
    bool canJump(vector<int>& nums) {
        int len = nums.size();
        if(len == 1) return true;
        
        bool dp[len];
        memset(dp, false, sizeof(dp));
        //for(int j=0; j<len; j++) dp[j] = false;
        dp[len-1] = true;
        int last = len-1;
        int i = last;
        
        while(i--) {
            if(nums[i] >= last - i) {
                dp[i] = true;
                last = i;
            }
        }
        return dp[0];
    }
};