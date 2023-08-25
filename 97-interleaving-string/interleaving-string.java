class Solution {
    Boolean[][][] dp;
    boolean solve(String s1, String s2, String s3, int idx1, int idx2, int idx3) {
        if(idx1 == s1.length() && idx2 == s2.length() && idx3 == s3.length()) return true;
        if(idx3 >= s3.length() && (idx1 < s1.length() || idx2 < s2.length())) return false;
        if(idx1 < s1.length() && idx2 < s2.length() && dp[idx1][idx2][idx3] != null) return dp[idx1][idx2][idx3];
        boolean ans = false;
        if(idx1 < s1.length() && s1.charAt(idx1) == s3.charAt(idx3)) ans = ans || solve(s1, s2, s3, idx1+1, idx2, idx3+1);
        if(idx2 < s2.length() && s2.charAt(idx2) == s3.charAt(idx3)) ans = ans || solve(s1, s2, s3, idx1, idx2+1, idx3+1);
        return dp[idx1][idx2][idx3] = ans;
    }
    public boolean isInterleave(String s1, String s2, String s3) {
        dp = new Boolean[s1.length()+1][s2.length()+1][s3.length()+1];
        return solve(s1, s2, s3, 0, 0, 0);
    }
}