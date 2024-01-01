/**
 * @param {string} s
 * @param {number} k
 * @return {number}
 */
var getLengthOfOptimalCompression = function(s, k) {
    let dp = new Array(s.length+1);

    for(let i=0; i<dp.length; i++) {
        dp[i] = new Array(k+1).fill(-1);
    }

    function cost(run) {
        if(run === 0) return 0;
        else if(run === 1) return 1;
        else if(run <= 9) return 2;
        else if(run <= 99) return 3;
        return 4;
    }

    function solve(si, ki) {
        if(ki < 0) return 1e8;
        if(si === s.length) return 0;

        // const key = `${si}_${ki}`;
        // if(key in dp) return dp[key];
        if(dp[si][ki] != -1) return dp[si][ki];

        let ans = 1e8;
        let run = 0;
        let deleted = 0;
        for(let j=si; j<s.length; j++) {
            if(s[j] === s[si]) {
                run++;
            }
            else deleted++;
            ans = Math.min(ans, solve(j+1, ki-j+si-1));
            ans = Math.min(ans, cost(run) + solve(j+1, ki-deleted));
        }
        return dp[si][ki] = ans;
    }

    return solve(0, k);
};