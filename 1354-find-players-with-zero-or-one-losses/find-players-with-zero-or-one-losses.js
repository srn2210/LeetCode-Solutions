/**
 * @param {number[][]} matches
 * @return {number[][]}
 */
var findWinners = function(matches) {
    let map = new Map();
    for(let [winner, loser] of matches) {
        if(!map.has(winner)) map.set(winner, 0);
        if(!map.has(loser)) map.set(loser, 0);
        map.set(loser, map.get(loser)+1);
    }
    let ans = [];
    ans.push([]);
    ans.push([]);
    for(let [player, count] of map) {
        if(count === 0) ans[0].push(player);
        if(count === 1) ans[1].push(player);
    }
    ans[0].sort((a,b) => a-b);
    ans[1].sort((a,b) => a-b);
    return ans;
};