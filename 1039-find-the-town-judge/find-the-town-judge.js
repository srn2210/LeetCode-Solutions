/**
 * @param {number} n
 * @param {number[][]} trust
 * @return {number}
 */
var findJudge = function(n, trust) {
    let indeg = new Array(n+1).fill(0);
    let outdg = new Array(n+1).fill(0);
    for(let t of trust) {
        outdg[t[0]]++;
        indeg[t[1]]++;
    }
    for(let i=1; i<=n; i++) {
        if(indeg[i] === n-1 && outdg[i] === 0) {
            return i;
        }
    }
    return -1;
};