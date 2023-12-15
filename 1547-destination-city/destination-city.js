/**
 * @param {string[][]} paths
 * @return {string}
 */
var destCity = function(paths) {
    let set = new Set();
    paths.forEach((path) => {
        set.add(path[0]);
        set.add(path[1]);
    });
    paths.forEach((path) => {
        set.delete(path[0]);
    });
    let ans = '';
    set.forEach((s) => ans = s);
    return ans;
};