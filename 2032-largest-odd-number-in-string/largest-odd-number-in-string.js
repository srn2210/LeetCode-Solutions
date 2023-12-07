/**
 * @param {string} num
 * @return {string}
 */
var largestOddNumber = function(num) {
    let right = -1;
    for(let i=num.length-1; i>=0; i--) {
        if(num[i] % 2 !== 0) {
            right = i;
            break;
        }
    }
    let ans = '';
    for(let i=0; i<=right; i++) {
        ans += num[i];
    }
    return ans;
};