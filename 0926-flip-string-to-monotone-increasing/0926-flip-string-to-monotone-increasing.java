class Solution {
    public int minFlipsMonoIncr(String s) {
        int[] dp = new int[s.length()+1];
        int one = 0;
        for(int i=1; i<=s.length(); i++) {
            if(s.charAt(i-1) == '0') {
                dp[i] = Math.min(dp[i-1] + 1, one);
            }
            else {
                dp[i] = dp[i-1];
                one++;
            }
        }
        return dp[s.length()];
    }
}