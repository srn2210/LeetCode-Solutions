/**
 * @param {number} n
 * @return {boolean}
 */
var isPowerOfTwo = function(n) {
    if(n < 0) return false;
    let count = 0;
    while(n) {
        if(n & 1 > 0) count++;
        n >>= 1;
    }
    return count === 1;
};