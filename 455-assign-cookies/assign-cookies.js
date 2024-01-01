/**
 * @param {number[]} g
 * @param {number[]} s
 * @return {number}
 */
var findContentChildren = function(g, s) {
    g.sort((a,b) => a-b);
    s.sort((a,b) => a-b);
    let cookie = 0;
    let child = 0;
    let ans = 0;
    while(child < g.length && cookie < s.length) {
        if(s[cookie] >= g[child]) {
            ans++;
            child++;
        }
        cookie++;
    }
    return ans;
};