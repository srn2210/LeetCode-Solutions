class Solution {
public:
    int maxSubarraySumCircular(vector<int>& nums) {
        int n = nums.size();
        vector<int> prefix(2 * n + 1);
        prefix[0] = 0;
        for(int i=0; i<2*n; i++) {
            prefix[i+1] = prefix[i] + nums[i % n];
        }
        deque<int> dq;
        dq.push_back(0);
        int ans = INT_MIN;
        for(int i=1; i<prefix.size(); i++) {
            while(!dq.empty() && dq.front() < i - n) {
                dq.pop_front();
            }
            ans = max(ans, prefix[i]-prefix[dq.front()]);
            while(!dq.empty() && prefix[dq.back()] >= prefix[i]) {
                dq.pop_back();
            }
            dq.push_back(i);
        }
        return ans;
    }
};