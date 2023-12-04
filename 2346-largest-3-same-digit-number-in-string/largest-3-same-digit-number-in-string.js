/**
 * @param {string} num
 * @return {string}
 */
var largestGoodInteger = function(num) {
    let ans = -1;
    for(let i=0; i<num.length-2; i++) {
        if(num[i] === num[i+1] && num[i] === num[i+2]) {
            ans = Math.max(ans, num[i]);
        }
    }
    return ans === -1 ? "" : "" + ans + ans + ans;
};