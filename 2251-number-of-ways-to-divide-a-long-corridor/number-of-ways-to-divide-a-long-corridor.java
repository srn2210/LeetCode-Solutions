class Solution {
    int mod = (int)1e9+7;
    // int[] dp;
    // int solve(String corr, int idx) {
    //     if(idx >= corr.length()) return 1;
    //     if(dp[idx] != -1) return dp[idx];
    //     int curr = idx;
    //     int count = 0;
    //     long ans = 0;
    //     while(idx < corr.length() && count < 2) {
    //         if(corr.charAt(idx) == 'S') count++;
    //         idx++;
    //     }
    //     if(count < 2) return 0;
    //     ans += solve(corr, idx);
    //     ans %= mod;
    //     while(idx < corr.length()) {
    //         if(corr.charAt(idx) == 'P') {
    //             ans += solve(corr, idx+1);
    //             ans %= mod;
    //             idx++;
    //         }
    //         else break;
    //     }
    //     return dp[curr] = (int)ans%mod;
    // }
    public int numberOfWays(String corridor) {
        long ans = 1;
        // dp = new int[corridor.length()+1];
        // Arrays.fill(dp, -1);
        StringBuilder s = new StringBuilder();
        int streak = 0;
        var q = new LinkedList<String>();
        for(int i=0; i<corridor.length(); i++) {
            if(corridor.charAt(i) == 'S') {
                if(streak != 0) {
                    q.add(String.valueOf(streak+1));
                    streak = 0;
                }
                boolean flag = true;
                for(int j=i+1; j<corridor.length(); j++) {
                    if(corridor.charAt(j) == 'S') {
                        s.append('S');
                        flag = false;
                        i = j;
                        q.add("S");
                        break;
                    }
                }
                if(flag) return 0;
            }
            else {
                streak++;
            }
        }
        if(q.isEmpty()) return 0;
        if(!q.peek().equals("S")) q.poll();
        // System.out.println(q);
        while(!q.isEmpty()) {
            if(q.peek().equals("S")) q.poll();
            else {
                int t = Integer.parseInt(q.poll());
                ans = ans * t;
                ans %= mod;
            }
        }
        // for(int[] a : q) System.out.println(Arrays.toString(a));
        // return solve(s.toString(), 0);
        return (int)ans;
    }
}