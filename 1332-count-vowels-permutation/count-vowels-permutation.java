class Solution {
    int mod = (int)1e9+7;
    char[] vowels = {'a', 'e', 'i', 'o', 'u'};
    int[][] dp;
    int idx(char ch) {
        switch(ch) {
            case 'a':
                return 0;
            case 'e':
                return 1;
            case 'i':
                return 2;
            case 'o':
                return 3;
            case 'u':
                return 4;
        }
        return 0;
    }
    int solve(char ch, int n) {
        if(n == 0) return 1;
        if(dp[idx(ch)][n] != -1) return dp[idx(ch)][n];
        long ans = 0;
        switch(ch) {
            case 'a':
                ans += solve('e', n-1);
                ans %= mod;
                break;
            case 'e':
                ans += solve('a', n-1);
                ans %= mod;
                ans += solve('i', n-1);
                ans %= mod;
                break;
            case 'i':
                for(char c : vowels) {
                    if(c == 'i') continue;
                    ans += solve(c, n-1);
                    ans %= mod;
                }
                break;
            case 'o':
                ans += solve('i', n-1);
                ans %= mod;
                ans += solve('u', n-1);
                ans %= mod;
                break;
            case 'u':
                ans += solve('a', n-1);
                ans %= mod;
                break;
        }
        return dp[idx(ch)][n] = (int)ans;
    }
    public int countVowelPermutation(int n) {
        int ans = 0;
        dp = new int[5][n+1];
        for(int i=0; i<dp.length; i++) Arrays.fill(dp[i], -1);
        for(char ch : vowels) {
            ans += solve(ch, n-1);
            ans %= mod;
        }
        return ans;
    }
}