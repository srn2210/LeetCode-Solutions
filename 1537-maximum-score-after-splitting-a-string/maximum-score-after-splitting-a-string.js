/**
 * @param {string} s
 * @return {number}
 */
var maxScore = function(s) {
    let ans = 0, curr = 0, total = 0;
    for(let ch of s) total += ch - '0';
    for(let i=0; i<s.length-1; i++) {
        curr += (s[i] - '0') ^ 1;
        total -= s[i] - '0';
        ans = Math.max(ans, curr + total);
    }
    return ans;
};