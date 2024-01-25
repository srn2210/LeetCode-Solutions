/**
 * @param {string} text1
 * @param {string} text2
 * @return {number}
 */
var longestCommonSubsequence = function(text1, text2) {
    let m = text1.length, n = text2.length;
    let dp = new Array(m);
    for(let i=0; i<m; i++) dp[i] = new Array(n).fill(-1);
    function solve(idx1, idx2) {
        if(idx1 === m || idx2 === n) return 0;
        if(dp[idx1][idx2] != -1) return dp[idx1][idx2];
        let ans = 0;
        if(text1[idx1] === text2[idx2]) ans = 1 + solve(idx1+1, idx2+1);
        else {
            ans = Math.max(solve(idx1+1, idx2), solve(idx1, idx2+1));
        }
        return dp[idx1][idx2] = ans;
    }
    return solve(0, 0);
};