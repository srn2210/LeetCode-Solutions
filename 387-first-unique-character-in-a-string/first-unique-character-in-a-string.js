/**
 * @param {string} s
 * @return {number}
 */
var firstUniqChar = function(s) {
    let arr = new Array(26).fill(-1);
    let ans = 1e6;

    for(let i=0; i<s.length; i++) {
        let idx = s.charCodeAt(i)-'a'.charCodeAt(0);
        if(arr[idx] < 0) arr[idx] = i;
        else arr[idx] = 1e6;
    }

    for(let freq of arr) {
        if(freq !== -1) ans = Math.min(ans, freq);
    }

    return ans === 1e6 ? -1 : ans;
};