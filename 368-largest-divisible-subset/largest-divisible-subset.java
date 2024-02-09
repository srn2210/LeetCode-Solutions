class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int[] prev = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(prev, -1);
        int maxInd = 0;
        int maxAns = 0;
        Arrays.sort(nums);
        for(int i=0; i<n; i++) {
            for(int j=i-1; j>=0; j--) {
                if(nums[i] % nums[j] == 0 && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                    if(dp[i] > maxAns) {
                        maxAns = dp[i];
                        maxInd = i;
                    }
                }
            }
        }
        var ans = new ArrayList<Integer>();
        while(maxInd != -1) {
            ans.add(nums[maxInd]);
            maxInd = prev[maxInd];
        }
        return ans;
    }
}