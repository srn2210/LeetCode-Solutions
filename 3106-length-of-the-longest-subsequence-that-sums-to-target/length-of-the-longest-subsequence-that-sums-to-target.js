/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var lengthOfLongestSubsequence = function(nums, target) {
    const n = nums.length;
    const dp = new Array(n+1);
    for(let i=0; i<=n; i++) {
        dp[i] = new Array(target+1).fill(-1);
    }

    for(let i=0; i<=n; i++) {
        dp[i][0] = 0;
    }

    for(let i=1; i<=target; i++) {
        for(let j=1; j<=n; j++) {
            dp[j][i] = dp[j-1][i];
            if(i >= nums[j-1] && dp[j-1][i-nums[j-1]] != -1) dp[j][i] = Math.max(dp[j-1][i-nums[j-1]] + 1, dp[j][i]);
        }
    }

    return dp[n][target];
};