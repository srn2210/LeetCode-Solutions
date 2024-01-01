/**
 * @param {string} s
 * @param {number} k
 * @return {number}
 */
var getLengthOfOptimalCompression = function(s, k) {
    let dp = new Map();

    function cost(run) {
        if(run === 0) return 0;
        else if(run === 1) return 1;
        else if(run <= 9) return 2;
        else if(run <= 99) return 3;
        return 4;
    }

    function solve(si, ki, prev, run) {
        if(ki < 0) return 1e8;
        if(si === s.length) return cost(run);

        const key = `${si}_${ki}_${prev}_${run}`;
        if(key in dp) return dp[key];

        let ans = solve(si+1, ki-1, prev, run);
        if(prev === s[si]) {
            ans = Math.min(ans, solve(si+1, ki, s[si], run+1));
        }
        else {
            ans = Math.min(ans, cost(run) + solve(si+1, ki, s[si], 1));
        }
        return dp[key] = ans;
    }

    return solve(0, k, '', 0);
};