class Solution {
    int mod = (int)1e9+7;
    public int numRollsToTarget(int n, int k, int target) {
        int[] prev = new int[target+1];
        prev[0] = 1;

        for(int i=1; i<=n; i++) {
            int[] curr = new int[target+1];
            for(int j=1; j<=k; j++) {
                for(int l=j; l<=target; l++) {
                    curr[l] += prev[l-j];
                    curr[l] %= mod;
                }
            }
            prev = curr;
        }

        return prev[target];
    }
}