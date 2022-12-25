class Solution {
    /*int solve(int[] dp, int[] nums, int sum, int idx, int target) {
        if(idx >= nums.length) return 0;        
        if(sum > target) return -1;
        if(dp[idx] != -1) return dp[idx];
        return dp[idx] = Math.max(solve(dp, nums, sum, idx+1, target), 1 + solve(dp, nums, sum+nums[idx], idx+1, target));
    }*/
    public int[] answerQueries(int[] nums, int[] queries) {
        int[] list = new int[queries.length];
        //int[] dp = new int[nums.length];
        //Arrays.fill(dp, -1);
        Arrays.sort(nums);
        for(int i=0; i<queries.length; i++) {
            int sum = 0;
            for(int j=0; j<nums.length; j++) {
                sum += nums[j];
                if(sum > queries[i]) {
                    break;
                }
                list[i] = j+1;
            }
        }
        return list;
    }
}