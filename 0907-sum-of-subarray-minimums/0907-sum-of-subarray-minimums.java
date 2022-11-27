class Solution {
    public int sumSubarrayMins(int[] arr) {
        int mod = 1000000007;
        int ans = 0;
        int[] dp = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        st.push(0);
        dp[0] = arr[0];
        for(int i=1; i<arr.length; i++) {
            if(arr[st.peek()] < arr[i]) {
                st.push(i);
                dp[i] = dp[i-1] + arr[i];
            }
            else {
                while(!st.isEmpty() && arr[st.peek()] > arr[i]) {
                    st.pop();
                }
                if(st.isEmpty()) {
                    st.push(i);
                    dp[i] = (i+1) * arr[i];
                }
                else {
                    dp[i] = dp[st.peek()] + (arr[i] * (i - st.peek()));
                    st.push(i);
                }
            }
        }
        for(int i:dp) {
            ans += i;
            ans %= mod;
        }
        return ans;
    }
}