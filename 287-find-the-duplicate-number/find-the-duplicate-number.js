/**
 * @param {number[]} nums
 * @return {number}
 */
var findDuplicate = function(nums) {
    let fast = 0;
    let slow = 0;
    while(true) {
        fast = nums[nums[fast]];
        slow = nums[slow];
        if(nums[slow] === nums[fast]) break;
    }
    let first = 0;
    while(first !== slow) {
        first = nums[first];
        slow = nums[slow];
    }
    return slow;
};