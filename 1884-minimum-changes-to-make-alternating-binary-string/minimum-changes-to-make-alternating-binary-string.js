/**
 * @param {string} s
 * @return {number}
 */
var minOperations = function(s) {
    let prev1 = 0, prev2 = 1;
    let ans1 = 0, ans2 = 0;
    for(let ch of s) {
        let c = ch - '0';
        if(c !== prev1) {
            ans1++;
        }
        if(c !== prev2) {
            ans2++;
        }
        prev1 ^= 1;
        prev2 ^= 1;
    }
    return Math.min(ans1, ans2);
};