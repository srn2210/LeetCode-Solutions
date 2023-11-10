/**
 * @param {number[][]} adjacentPairs
 * @return {number[]}
 */
var restoreArray = function(adjacentPairs) {
    const map = new Map();

    for(let pair of adjacentPairs) {
        if(!map.has(pair[0])) map.set(pair[0], []);
        map.get(pair[0]).push(pair[1]);
        if(!map.has(pair[1])) map.set(pair[1], []);
        map.get(pair[1]).push(pair[0]);
    }

    let start = 0;

    for(let [key, value] of map) {
        if(value.length == 1) {
            start = key;
            break;
        }
    }

    let vis = new Array(adjacentPairs.length+1).fill(false);
    let ans = new Array(adjacentPairs.length+1).fill(0);
    let itr = 0;

    function dfs(node) {
        vis[node] = true;

        ans[itr++] = node;

        for(let neigh of map.get(node)) {
            if(!vis[neigh]) {
                dfs(neigh);
            }
        }
    }

    dfs(start);

    return ans;
};