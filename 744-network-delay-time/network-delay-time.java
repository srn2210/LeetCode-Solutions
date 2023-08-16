class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] ans = new int[n+1];
        int max = (int)1e8;
        Arrays.fill(ans, max);
        ans[k] = 0;
        for(int i=0; i<n-1; i++) {
            for(int[] time : times) {
                if(ans[time[0]] + time[2] < ans[time[1]]) ans[time[1]] = ans[time[0]] + time[2];
            }
        }
        int res = 0;
        for(int i=1; i<ans.length; i++) res = Math.max(res, ans[i]);
        return res == max ? -1 : res;
    }
}