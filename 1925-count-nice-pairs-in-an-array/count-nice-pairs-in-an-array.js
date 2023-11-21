/**
 * @param {number[]} nums
 * @return {number}
 */
var countNicePairs = function(nums) {
    let map = new Map();
    let res = 0;
    let mod = 1e9+7;

    function reverse(num) {
        let cpy = num;
        let ans = 0;

        while(num) {
            ans = (ans * 10) + (num % 10);
            num = num - (num % 10);
            num /= 10;
        }
        let diff = cpy - ans;
        if(!map.has(diff)) map.set(diff, 0);
        map.set(diff, map.get(diff) + 1);
    }

    for(let num of nums) {
        reverse(num);
    }

    for(let val of map.values()) {
        if(val <= 1) continue;

        res += (val * (val-1)) / 2;
        res %= mod;
    }

    return res;
};