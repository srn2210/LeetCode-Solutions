/**
 * @param {number} n
 * @return {number}
 */
var numberOfMatches = function(n) {
    let solve = (teams) => {
        if(teams === 1) return 0;
        let ans = 0;
        if(teams % 2 === 0) {
            ans = teams / 2 + solve(teams / 2);
        }
        else {
            ans = (teams-1) / 2 + solve((teams - 1) / 2 + 1);
        }
        return ans;
    }
    return solve(n);
};