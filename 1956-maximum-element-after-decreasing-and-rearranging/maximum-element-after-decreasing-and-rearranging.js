/**
 * @param {number[]} arr
 * @return {number}
 */
var maximumElementAfterDecrementingAndRearranging = function(arr) {
    const n = arr.length;
    const ar = Array(n+1).fill(0);
    for(let num of arr) {
        ar[Math.min(num, n)]++;
    }
    let ans = 1;
    for(let i=1; i<=n; i++) {
        ans = Math.min(i, ans + ar[i]);
    }
    return ans;
};