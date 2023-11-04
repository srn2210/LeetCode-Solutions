/**
 * @param {number} n
 * @param {number[][]} connections
 * @return {number[][]}
 */
var criticalConnections = function(n, connections) {
    const disc = new Array(n);
    const low = new Array(n);
    const ans = [];
    const graph = new Array(n);
    let time = 0;
    
    for(let i=0; i<n; i++) {
        graph[i] = [];
    }

    for(con of connections) {
        graph[con[0]].push(con[1]);
        graph[con[1]].push(con[0]);
    }

    function dfs(u, p) {
        low[u] = disc[u] = ++time;

        for(let v of graph[u]) {
            if(v === p) {
                continue;
            }
            if(!disc[v]) {
                dfs(v, u);
                if(disc[u] < low[v]) {
                    ans.push([u, v]);
                }
                low[u] = Math.min(low[u], low[v]);
            }
            else {
                low[u] = Math.min(low[u], disc[v]);
            }
        }
    }

    for(let i=0; i<n; i++) {
        if(!disc[i]) {
            dfs(i, i);
        }
    }

    return ans;
};