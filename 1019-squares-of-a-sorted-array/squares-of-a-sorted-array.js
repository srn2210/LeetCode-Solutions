/**
 * @param {number[]} nums
 * @return {number[]}
 */
var sortedSquares = function(nums) {
    let left = 0, right = nums.length-1;
    let ptr = nums.length-1;
    let ans = new Array(nums.length).fill(-1);
    while(left <= right) {
        if(Math.abs(nums[left]) < Math.abs(nums[right])) {
            ans[ptr--] = nums[right] * nums[right];
            right--;
        }
        else {
            ans[ptr--] = nums[left] * nums[left];
            left++;
        }
    }
    return ans;
};