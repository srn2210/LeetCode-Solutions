/**
 * @param {number} n
 * @param {number[]} left
 * @param {number[]} right
 * @return {number}
 */
var getLastMoment = function(n, left, right) {
    let max = -1;
    for(val of left) max = Math.max(max, val);
    for(val of right) max = Math.max(max, n - val);
    return max;
};