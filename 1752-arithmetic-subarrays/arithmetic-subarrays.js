/**
 * @param {number[]} nums
 * @param {number[]} l
 * @param {number[]} r
 * @return {boolean[]}
 */
var checkArithmeticSubarrays = function(nums, l, r) {
    let n = nums.length;
    const ans = [];

    for(let i=0; i<l.length; i++) {
        let s = new Set();
        let min = 1e9;
        let max = -1e9;
        for(let curr=l[i]; curr<=r[i]; curr++) {
            s.add(nums[curr]);
            min = Math.min(min, nums[curr]);
            max = Math.max(max, nums[curr]);
        }
        let diff = (max - min) / (r[i] - l[i]);
        if(diff % 1 != 0) {
            ans.push(false);
            continue;
        }
        let curr = min;
        let flag = true;
        for(let k=0; k<=r[i]-l[i]; k++) {
            if(!s.has(curr)) {
                flag = false;
                break;
            }
            curr += diff;
        }
        ans.push(flag);
    }

    return ans;
};