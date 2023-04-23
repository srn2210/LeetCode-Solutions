class Solution {
    int mod = 1000000007;
    int solve(String s, int k, int idx, int[] dp) {
        if(idx == s.length()) {
            return 1;
        }
        if(dp[idx] != -1) return dp[idx];
        long ans = 0;
        long t1 = 0;
        for(int i=idx; i<s.length(); i++) {
            t1 = t1 * 10;
            t1 += Character.getNumericValue(s.charAt(i));
            if(t1 == 0 || t1 > k) break;
            ans %= mod;
            ans += solve(s, k, i+1, dp) % mod;
            ans %= mod;
        }
        return dp[idx] = (int)(ans % mod);
    }
    public int numberOfArrays(String s, int k) {
        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);
        return solve(s, k, 0, dp);
    }
}