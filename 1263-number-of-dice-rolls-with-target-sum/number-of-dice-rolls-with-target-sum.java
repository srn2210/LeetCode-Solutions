class Solution {
    public int numRollsToTarget(int n, int k, int target) {
        int mod = (int)1e9+7;
        int[] prev = new int[target+1];
        int[] curr = new int[target+1];
        prev[0] = 1;

        for(int i=1; i<=n; i++) {
            for(int j=1; j<=k; j++) {
                for(int l=j; l<=target; l++) {
                    curr[l] += prev[l-j];
                    curr[l] %= mod;
                }
            }
            int[] temp = prev;
            prev = curr;
            for(int j=0; j<prev.length; j++) temp[j] = 0;
            curr = temp;
        }

        return prev[target];
    }
}