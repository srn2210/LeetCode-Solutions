/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var findMatrix = function(nums) {
    let ans = [];
    let map = new Map();
    let max = 0;
    for(let num of nums) {
        let curr = 1;
        if(!map.has(num)) map.set(num, curr);
        else {
            curr = map.get(num)+1;
            map.set(num, curr);
        }
        max = Math.max(max, curr);
        while(ans.length < max) ans.push([]);
        ans[curr-1].push(num);
    }
    return ans;
};