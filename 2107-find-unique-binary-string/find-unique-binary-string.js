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
        if(!s.has(i)) ans = i;
    }
    ans = ans.toString(2);
    while(ans.length < nums.length) {
        ans = '0' + ans;
    }
    return ans;
};