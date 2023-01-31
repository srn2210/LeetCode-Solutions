class Solution {
    public int bestTeamScore(int[] scores, int[] ages) {
        int[][] arr = new int[scores.length][2];
        for(int i=0; i<scores.length; i++) {
            arr[i][0] = scores[i];
            arr[i][1] = ages[i];
        }
        Arrays.sort(arr, (a,b) -> Integer.compare(a[0], b[0]) == 0 ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]));
        int[] dp = new int[scores.length];
        int ans = Integer.MIN_VALUE;
        for(int i=0; i<scores.length; i++) {
            int max = Integer.MIN_VALUE;
            for(int j=i-1; j>=0; j--) {
                if(arr[j][1] > arr[i][1]) continue;
                max = Math.max(max, dp[j]);
            }
            max = max == Integer.MIN_VALUE ? 0 : max;
            dp[i] = arr[i][0] + max;
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}