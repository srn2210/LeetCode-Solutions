class Solution {
    int calc(int num) {
        return (num * (num+1)) / 2;
    }
    public int sumSubarrayMins(int[] arr) {
        var st = new Stack<Integer>();
        int mod = (int)1e9 + 7;
        int n = arr.length;
        long ans = 0;
        st.push(0);
        for(int i=1; i<n; i++) {
            while(!st.isEmpty() && arr[st.peek()] > arr[i]) {
                int curr = st.pop();
                int prev = st.isEmpty() ? -1 : st.peek();
                int right = i - curr - 1;
                int left = curr - prev - 1;
                ans += arr[curr] * ((long)(right+1) * (left+1));
                ans %= mod;
            }
            st.push(i);
        }
        while(!st.isEmpty()) {
            int curr = st.pop();
            int prev = st.isEmpty() ? -1 : st.peek();
            int right = n - curr - 1;
            int left = curr - prev - 1;
            ans += arr[curr] * ((long)(right+1) * (left+1));
            ans %= mod;
        }
        return (int)ans;
    }
}