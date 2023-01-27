class Solution {
    boolean solve(String s, Set<String> set, Boolean[] dp, int idx) {
        if(idx == s.length()) return true;
        if(dp[idx] != null) return dp[idx];
        for(int i=idx; i<s.length(); i++) {
            var t = s.substring(idx, i+1);                              // can be improved further by precalculating all substrings
            if(set.contains(t) && solve(s, set, dp, i+1)) return dp[i] = true;
        }
        return dp[idx] = false;
    }
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> ans = new ArrayList<>();
        Set<String> set = new HashSet<>();
        int least = Integer.MAX_VALUE;
        int least2 = Integer.MAX_VALUE;
        for(String s : words) {
            if(s.length() <= least) {
                least2 = least;
                least = s.length();
            }
            else if(s.length() < least2) {
                least2 = s.length();
            }
            set.add(s);
        }
        for(String s : words) {
            if(s.length() >= least + least2) {
                set.remove(s);
                if(solve(s, set, new Boolean[s.length()], 0)) ans.add(s);
                set.add(s);
            }
        }
        return ans;
    }
}