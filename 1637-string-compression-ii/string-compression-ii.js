/**
 * @param {string} s
 * @param {number} k
 * @return {number}
 */
var getLengthOfOptimalCompression = function(s, k) {
    let dp = new Array(s.length+2);

    for(let i=0; i<dp.length; i++) {
        dp[i] = new Array(k+2).fill(1e9);
    }

    dp[0][0] = 0;

    function cost(run) {
        if(run === 0) return 0;
        else if(run === 1) return 1;
        else if(run <= 9) return 2;
        else if(run <= 99) return 3;
        return 4;
    }

    for(let i=1; i<=s.length; i++) {
        for(let m=0; m<=k; m++) {

            let ans = m-1 >= 0 ? dp[i-1][m-1] : 1e8;
            let run = 0;
            let deleted = 0;
            for(let j=i; j>=1; j--) {
                if(s[j-1] === s[i-1]) {
                    run++;
                }
                else deleted++;
                if(m - deleted >= 0) dp[i][m] = Math.min(dp[i][m], cost(run) + dp[j-1][m-deleted]);
            }
            dp[i][m] = Math.min(dp[i][m], ans);
        }
    }

    return dp[s.length][k];
};