/**
 * @param {number[]} nums
 * @return {number}
 */
var lengthOfLIS = function(nums) {
    let ans = [];
    let n = nums.length;

    function binarySearch(cand) {
        let left = 0, right = ans.length;
        while(left < right) {
            let mid = Math.floor((right + left) / 2);
            if(cand <= ans[mid]) right = mid;
            else left = mid + 1;
        }
        return left;
    }

    for(let i=0; i<n; i++) {
        let cand = nums[i];
        let pos = binarySearch(cand);
        if(pos === ans.length) ans.push(cand);
        else if(ans[pos] > cand) ans[pos] = cand;
    }

    return ans.length;
};