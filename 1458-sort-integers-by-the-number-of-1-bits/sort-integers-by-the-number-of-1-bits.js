/**
 * @param {number[]} arr
 * @return {number[]}
 */
var sortByBits = function(arr) {
    const buckets = new Array(32);

    for(let i=0; i<buckets.length; i++) {
        buckets[i] = [];
    }

    function countBits(val) {
        let count = 0;
        for(let i=0; i<=31; i++) {
            if((val & (1 << i)) != 0) count++;
        }
        return count;
    }

    for(let i=0; i<arr.length; i++) {
        let c = countBits(arr[i]);
        buckets[c].push(arr[i]);
    }

    for(let i=0; i<buckets.length; i++) {
        buckets[i].sort((a, b) => a - b);
    }

    const ans = [];

    for(let i=0; i<buckets.length; i++) {
        for(val of buckets[i]) ans.push(val);
    }
    return ans;
};