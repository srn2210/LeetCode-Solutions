/**
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
var isAnagram = function(s, t) {
    let map = new Map();
    for(let c of s) {
        if(!map.has(c)) map.set(c, 0);
        map.set(c, map.get(c)+1);
    }
    for(let c of t) {
        if(!map.has(c)) return false;
        if(map.get(c) === 1) map.delete(c);
        else map.set(c, map.get(c)-1);
    }
    return map.size === 0;
};