/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var maxFrequency = function(nums, k) {
    nums.sort((a,b) => a-b);
    let ans = 0, left = 0, right = 0, curr = 0;

    while(right < nums.length) {
        curr += nums[right];

        while((right - left + 1) * nums[right] - curr > k) {
            curr -= nums[left];
            left++;
        }

        ans = Math.max(ans, right - left + 1);
        right++;
    }

    return ans;
};