/**
 * @param {string} s
 * @return {number}
 */
var countHomogenous = function(s) {
    let ans = 0;
    let count = 0;
    let mod = 1e9+7;
    
    for(let i=0; i<s.length; i++) {
        if(s[i] === s[i-1]) {
            count++;
        }
        else {
            count = 1;
        }
        ans += count;
        ans %= mod;
    }

    return ans % mod;

};