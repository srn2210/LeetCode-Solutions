/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var maxSubarrayLength = function(nums, k) {
    let freq = new Map();
    let left = 0, right = 0;
    let maxFreq = 0, maxNum = -1;
    let ans = 0;
    while(right < nums.length) {
        if(!freq.has(nums[right])) freq.set(nums[right], 0);
        freq.set(nums[right], freq.get(nums[right])+1);
        if(freq.get(nums[right]) > maxFreq) {
            maxFreq = freq.get(nums[right]);
            maxNum = nums[right];
        }
        while(maxFreq > k) {
            if(nums[left] === maxNum) maxFreq--;
            freq.set(nums[left], freq.get(nums[left])-1);
            left++;
        }
        ans = Math.max(ans, right-left+1);
        right++;
    }
    return ans;
};