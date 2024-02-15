/**
 * @param {number[]} nums
 * @return {number}
 */
var largestPerimeter = function(nums) {
    let ans = -1;
    nums.sort((a,b) => a-b);
    let sum = 0;
    for(let i=0; i<nums.length; i++) {
        if(i >= 2 && nums[i] < sum) {
            ans = Math.max(ans, sum+nums[i]);
        }
        sum += nums[i];
    }
    return ans;
};