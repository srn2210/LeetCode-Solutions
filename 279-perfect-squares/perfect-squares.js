/**
 * @param {number} n
 * @return {number}
 */
var numSquares = function(n) {
    let perf = [];
    for(let i=1; i<=n; i++) {
        if(Math.sqrt(i) % 1 === 0) perf.push(i);
    }

    let dp = new Array(n+1).fill(-1);
    
    function solve(num) {
        if(num === 0) return 0;
        if(dp[num] !== -1) return dp[num];
        let ans = 1e9;
        let ind = Math.trunc(Math.sqrt(num));
        for(let i=ind-1; i>=0; i--) {
            ans = Math.min(ans, solve(num-perf[i]) + 1);
        }

        return dp[num] = ans;
    }

    return solve(n);
};