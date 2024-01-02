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
    }
    for(let i=0; i<max; i++) {
        ans.push([]);
    }
    for(let [key, value] of map) {
        for(let i=0; i<value; i++) {
            ans[i].push(key);
        }
    }
    return ans;
};