/**
 * @param {number[][]} nums
 * @return {number[]}
 */
var findDiagonalOrder = function(nums) {
    let map = new Map();
    let maxSum = 0;

    for(let i=nums.length-1; i>=0; i--) {
        for(let j=0; j<nums[i].length; j++) {
            let sum = i + j;
            maxSum = Math.max(maxSum, sum);
            if(!map.has(sum)) map.set(sum, []);
            map.get(sum).push(nums[i][j]);
        }
    }

    let ans = [];
    for(let i=0; i<=maxSum; i++) {
        for(let num of map.get(i)) {
            ans.push(num);
        }
    }
    return ans;
};