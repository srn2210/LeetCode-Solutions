class Solution {
    int mod = (int) 1e9+7;
    int solve(String[] words, int idx, String target, int tIdx, long[][] dp, int[][] charCount) {
        if(tIdx == target.length()) return 1;
        if(idx == words[0].length() || target.length() - tIdx > words[0].length() - idx) return 0;
        if(dp[idx][tIdx] != -1) return (int)dp[idx][tIdx];
        int ans = solve(words, idx+1, target, tIdx, dp, charCount) % mod;
        ans += ((long)charCount[target.charAt(tIdx)-'a'][idx] * solve(words, idx+1, target, tIdx+1, dp, charCount)) % mod;
        return (int)(dp[idx][tIdx] = ans % mod);
    }
    public int numWays(String[] words, String target) {
        long[][] dp = new long[words[0].length()][target.length()];
        int[][] charCount = new int[26][words[0].length()];
        for(int i=0; i<words.length; i++) {
            for(int j=0; j<words[0].length(); j++) {
                charCount[words[i].charAt(j)-'a'][j]++;
            }
        }
        for(int i=0; i<words[0].length(); i++) Arrays.fill(dp[i], -1);
        return solve(words, 0, target, 0, dp, charCount);
    }
}