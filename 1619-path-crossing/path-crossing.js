/**
 * @param {string} path
 * @return {boolean}
 */
var isPathCrossing = function(path) {
    let set = new Set();
    set.add("0,0");
    let x = 0, y = 0;
    for(let c of path) {
        if(c === 'N') y++;
        else if(c === 'S') y--;
        else if(c === 'E') x++;
        else x--;
        if(set.has(x+","+y)) return true;
        set.add(x+","+y);
    }
    return false;
};