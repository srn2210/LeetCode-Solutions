class Solution {
    int mod = (int)1e9+7;
    char[] vowels = {'a', 'e', 'i', 'o', 'u'};
    int[][] dp;
    int solve(char ch, int n) {
        if(n == 0) return 1;
        if(dp[ch-'a'][n] != -1) return dp[ch-'a'][n];
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
        return dp[ch-'a'][n] = (int)ans;
    }
    public int countVowelPermutation(int n) {
        int ans = 0;
        dp = new int[26][n+1];
        for(int i=0; i<26; i++) Arrays.fill(dp[i], -1);
        for(char ch : vowels) {
            ans += solve(ch, n-1);
            ans %= mod;
        }
        return ans;
    }
}