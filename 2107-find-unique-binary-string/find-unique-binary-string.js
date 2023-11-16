/**
 * @param {string[]} nums
 * @return {string}
 */
var findDifferentBinaryString = function(nums) {
    let s = new Set();
    let ans = "";
    for(let num of nums) {
        s.add(parseInt(num, 2));
    }
    for(let i=0; i<=nums.length; i++) {
        if(!s.has(i)) {
            return i.toString(2).padStart(nums.length, '0');
        }
    }
    return ans;
};