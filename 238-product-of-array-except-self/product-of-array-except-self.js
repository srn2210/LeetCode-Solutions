/**
 * @param {number[]} nums
 * @return {number[]}
 */
var productExceptSelf = function(nums) {
    let n = nums.length;
    let leftProd = new Array(n).fill(1);
    let rightProd = new Array(n).fill(1);
    let left = 1, right = 1;
    for(let i=0; i<n; i++) {
        leftProd[i] = left;
        rightProd[n-i-1] = right;
        left *= nums[i];
        right *= nums[n-i-1];
    }
    let ans = [];
    for(let i=0; i<n; i++) {
        ans.push(leftProd[i] * rightProd[i]);
    }
    return ans;
};