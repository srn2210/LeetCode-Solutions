/**
 * @param {number[]} nums
 * @return {number}
 */
var numberOfArithmeticSlices = function(nums) {
    let n = nums.length;

    // function solve(idx, diff) {
    //     if(idx === n) return 0;

    //     let ans = 0;
    //     for(let i=idx+1; i<n; i++) {
    //         ans += solve(i, nums[i]-nums[idx]);
    //     }
    // }

    // return solve(0, 0);

    let dp = new Map();
    let ans = 0;

    for(let i=0; i<n; i++) {
        for(let j=i-1; j>=0; j--) {
            let diff = nums[i] - nums[j];
            let key = j + "," + diff;
            let nKey = i + "," + diff;
            let upd = 0;
            let an = 0;
            if(dp.has(key)) upd = dp.get(key);
            if(dp.has(nKey)) an = dp.get(nKey);
            dp.set(nKey, upd + an + 1);
            ans += upd;
        }
    }

    return ans;
};