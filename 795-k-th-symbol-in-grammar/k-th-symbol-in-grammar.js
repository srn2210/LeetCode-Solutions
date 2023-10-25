/**
 * @param {number} n
 * @param {number} k
 * @return {number}
 */
var kthGrammar = function(n, k) {
    function solve(n, k) {
        if(n === 1) return 0
        if(k % 2 === 0) return solve(n-1, k/2) ^ 1
        else return solve(n-1, (k+1)/2)
    }
    return solve(n, k)
};