/**
 * @param {number[]} nums
 * @return {number[]}
 */
var getSumAbsoluteDifferences = function(nums) {
    let sum = 0;
    for(let num of nums) {
        sum += num;
    }
    let ans = [];
    let pre = 0, n = nums.length;
    for(let i=0; i<n; i++) {
        let left = (nums[i] * i) - pre;
        let right = (sum - pre - nums[i]) - ((n-i-1) * nums[i]);
        ans.push(left + right);
        pre += nums[i];
    }
    return ans;
};