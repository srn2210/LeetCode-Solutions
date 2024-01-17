/**
 * @param {number[]} arr
 * @return {boolean}
 */
var uniqueOccurrences = function(arr) {
    let map = new Map();
    let set = new Set();
    for(let a of arr) {
        if(!map.has(a)) map.set(a, 0);
        map.set(a, map.get(a) + 1);
    }
    for(let [key, value] of map) {
        if(set.has(value)) return false;
        else set.add(value);
    }
    return true;
};