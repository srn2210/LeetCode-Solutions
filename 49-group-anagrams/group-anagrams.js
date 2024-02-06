/**
 * @param {string[]} strs
 * @return {string[][]}
 */
var groupAnagrams = function(strs) {
    let map = new Map();
    for(let str of strs) {
        let arr = new Array(26).fill(0);
        for(let ch of str) {
            arr[ch.charCodeAt(0)-'a'.charCodeAt(0)]++;
        }
        let s = arr.toString();
        if(!map.has(s)) map.set(s, []);
        let t = map.get(s);
        t.push(str);
    }
    let ans = [];
    for(let [key, value] of map) {
        let temp = [];
        for(let str of value) {
            temp.push(str);
        }
        ans.push(temp);
    }
    return ans;
};