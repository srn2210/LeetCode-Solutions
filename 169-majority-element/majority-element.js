/**
 * @param {number[]} nums
 * @return {number}
 */
var majorityElement = function(nums) {
    // Boyer-Moore Voting Algorithm

    let max = nums[0];
    let count = 1;
    for(let i=1; i<nums.length; i++) {
        if(max === nums[i]) count++;
        else count--;
        if(count === 0) {
            max = nums[i]
            count = 1;
        }
    }
    return max;
};