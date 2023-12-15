/**
 * @param {string[][]} paths
 * @return {string}
 */
var destCity = function(paths) {
    let set = new Set();
    for(let path of paths) {
        set.add(path[0]);
        set.add(path[1]);
    }
    for(let path of paths) {
        set.delete(path[0]);
    }
    let ans = '';
    set.forEach((s) => ans = s);
    return ans;
};