class Solution {
    int[][] dp;
    int lcs(int[] s1, int[] s2, int idx1, int idx2) {
        if(idx1 == s1.length && idx2 == s2.length) {
            return 0;
        }
        else if(idx1 == s1.length) {
            int s = 0;
            for(int i=idx2; i<s2.length; i++) s += s2[i];
            return s;
        }
        else if(idx2 == s2.length) {
            int s = 0;
            for(int i=idx1; i<s1.length; i++) s += s1[i];
            return s;
        }
        if(dp[idx1][idx2] != -1) return dp[idx1][idx2];
        int ans = 0;
        if(s1[idx1] == s2[idx2]) ans = lcs(s1, s2, idx1+1, idx2+1);
        else {
            ans = Math.min(s1[idx1] + lcs(s1, s2, idx1+1, idx2), s2[idx2] + lcs(s1, s2, idx1, idx2+1));
        }
        return dp[idx1][idx2] = ans;
    }
    public int minimumDeleteSum(String s1, String s2) {
        int[] arr1 = new int[s1.length()];
        int[] arr2 = new int[s2.length()];
        for(int i=0; i<s1.length(); i++) {
            arr1[i] = (int)s1.charAt(i);
        }
        for(int i=0; i<s2.length(); i++) {
            arr2[i] = (int)s2.charAt(i);
        }
        dp = new int[s1.length()][s2.length()];
        for(int i=0; i<dp.length; i++) Arrays.fill(dp[i], -1);
        return lcs(arr1, arr2, 0, 0);
    }
}