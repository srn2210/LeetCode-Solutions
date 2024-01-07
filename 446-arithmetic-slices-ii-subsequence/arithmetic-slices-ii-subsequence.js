/**
 * @param {number[]} nums
 * @return {number}
 */
var numberOfArithmeticSlices = function(nums) {
    let n = nums.length;
    let dp = new Array(n);
    let ans = 0;

    for(let i=0; i<n; i++) dp[i] = new Map();

    for(let i=0; i<n; i++) {
        for(let j=i-1; j>=0; j--) {
            let diff = nums[i] - nums[j];
            let upd = 0;
            let an = 0;
            if(dp[j].has(diff)) upd = dp[j].get(diff);
            if(dp[i].has(diff)) an = dp[i].get(diff);
            dp[i].set(diff, upd + an + 1);
            ans += upd;
        }
    }

    return ans;
};