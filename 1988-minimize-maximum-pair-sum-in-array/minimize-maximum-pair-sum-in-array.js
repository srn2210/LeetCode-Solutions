/**
 * @param {number[]} nums
 * @return {number}
 */
var minPairSum = function(nums) {
    let max = 0, left = 0, right = nums.length-1;
    nums.sort((a,b) => a-b);
    while(left < right) max = Math.max(max, nums[left++] + nums[right--]);
    return max;
};