class Solution {
    boolean check(StringBuilder s) {
        int l = 0;
        int r = s.length()-1;
        while(l < r) {
            if(s.charAt(l++) != s.charAt(r--)) return false;
        }
        return true;
    }
    void backtrack(List<List<String>> ans, String s, String[][] dp, List<String> curr, int idx) {
        if(idx == s.length()) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        else {
            for(int i=idx; i<s.length(); i++) {
                if(dp[idx][i] == null) continue;
                curr.add(dp[idx][i]);
                backtrack(ans, s, dp, curr, i+1);
                curr.remove(curr.size()-1);
            }
        }
    }
    public List<List<String>> partition(String s) {
        int n = s.length();
        String[][] dp = new String[n][n];
        StringBuilder sb;
        for(int i=0; i<n; i++) {
            sb = new StringBuilder();
            for(int j=i; j<n; j++) {
                sb.append(s.charAt(j));
                if(check(sb)) dp[i][j] = sb.toString();
            }
        }
        List<List<String>> ans = new ArrayList<>();
        backtrack(ans, s, dp, new ArrayList<>(), 0);
        return ans;
    }
}