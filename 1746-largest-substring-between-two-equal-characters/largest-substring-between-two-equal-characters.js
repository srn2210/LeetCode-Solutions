/**
 * @param {string} s
 * @return {number}
 */
var maxLengthBetweenEqualCharacters = function(s) {
    let map = new Map();
    let ans = -1;
    for(let i=0; i<s.length; i++) {
        if(!map.has(s[i])) map.set(s[i], i);
        else ans = Math.max(ans, i - map.get(s[i]) - 1);
    }
    return ans;
};