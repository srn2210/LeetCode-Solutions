/**
 * @param {string} s
 * @param {string} t
 * @return {number}
 */
var minSteps = function(s, t) {
    let map = new Array(26).fill(0);
    for(let i=0; i<s.length; i++) {
        map[s.charCodeAt(i)-'a'.charCodeAt(0)]++;
        map[t.charCodeAt(i)-'a'.charCodeAt(0)]--;
    }
    let ans = 0;
    for(let count of map) {
        if(count > 0) ans += count;
    }
    return ans;
};