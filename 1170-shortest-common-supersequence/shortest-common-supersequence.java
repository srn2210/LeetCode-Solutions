class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        int[][] dp = new int[m+1][n+1];
        for(int i=1; i<=m; i++) {
            for(int j=1; j<=n; j++) {
                if(str1.charAt(i-1) == str2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        StringBuilder str = new StringBuilder();
        int i = m, j = n;
        while(i > 0 && j > 0) {
            if(dp[i][j] > dp[i-1][j] && dp[i][j] > dp[i][j-1]) {
                str.append(str1.charAt(i-1));
                i--;
                j--;
            }
            else if(dp[i-1][j] > dp[i][j-1]) {
                i--;
            }
            else {
                j--;
            }
        }
        String subseq = str.reverse().toString();
        StringBuilder ans = new StringBuilder();
        i = 0;
        j = 0;
        int k = 0;
        while(k < subseq.length()) {
            if(subseq.charAt(k) == str1.charAt(i) && subseq.charAt(k) == str2.charAt(j)) {
                ans.append(subseq.charAt(k++));
                i++;
                j++;
            }
            else if(subseq.charAt(k) == str1.charAt(i)) {
                ans.append(str2.charAt(j++));
            }
            else if(subseq.charAt(k) == str2.charAt(j)) ans.append(str1.charAt(i++));
            else {
                ans.append(str2.charAt(j++));
                ans.append(str1.charAt(i++));
            }
        }
        while(i < m) {
            ans.append(str1.charAt(i++));
        }
        while(j < n) {
            ans.append(str2.charAt(j++));
        }
        return ans.toString();
    }
}