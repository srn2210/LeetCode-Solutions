class Solution {
public:
    int shortestSubarray(vector<int>& nums, int k) {
        int n = nums.size();
        vector<long> prefix(n + 1);
        prefix[0] = 0;
        for(int i=0; i<n; i++) {
            prefix[i+1] = prefix[i] + (long)nums[i];
        }
        deque<int> dq;
        int ans = n + 1;
        for(int i=0; i<prefix.size(); i++) {
            while(!dq.empty() && prefix[i] <= prefix[dq.back()]) {
                dq.pop_back();
            }
            while(!dq.empty() && prefix[i] >= prefix[dq.front()] + k) {
                ans = min(ans, i - dq.front());
                dq.pop_front();
            }
            dq.push_back(i);
        }
        return ans == n + 1 ? -1 : ans;
    }
};