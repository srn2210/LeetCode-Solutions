class Solution {
public:
    int sumSubarrayMins(vector<int>& arr) {
        int dp[arr.size()];
        memset(dp, 0, sizeof(dp));
        stack<int> st;
        int ans = 0;
        st.push(0);
        dp[0] = arr[0];
        for(int i=1; i<arr.size(); i++) {
            if(arr[st.top()] < arr[i]) {
                st.push(i);
                dp[i] = dp[i-1] + arr[i];
            }
            else {
                while(!st.empty() && arr[st.top()] > arr[i]) {
                    st.pop();
                }
                if(st.empty()) {
                    st.push(i);
                    dp[i] = (i+1) * arr[i];
                }
                else {
                    dp[i] = dp[st.top()] + (arr[i] * (i - st.top()));
                    st.push(i);
                }
            }
        }
        for(int i:dp) {
            ans += i;
            ans %= 1000000007;
        }
        return ans;
    }
};