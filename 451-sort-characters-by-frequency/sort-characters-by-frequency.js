/**
 * @param {string} s
 * @return {string}
 */
var frequencySort = function(s) {
    let map = new Array(128);
    for(let i=0; i<map.length; i++) {
        map[i] = [0, i];
    }
    for(let ch of s) {
        let curr = ch.charCodeAt(0);
        map[curr][0]++;
    }
    map.sort((a,b) => b[0] - a[0]);
    let ans = '';
    for(let i=0; i<map.length; i++) {
        if(map[i][0] === 0) break;
        else {
            for(let j=0; j<map[i][0]; j++) {
                ans += String.fromCharCode(map[i][1]);
            }
        }
    }
    return ans;
};