/**
 * @param {string} word1
 * @param {string} word2
 * @return {boolean}
 */
var closeStrings = function(word1, word2) {
    let map1 = new Array(26).fill(0);
    let map2 = new Array(26).fill(0);
    for(let ch of word1) {
        map1[ch.charCodeAt(0)-'a'.charCodeAt(0)]++;
    }
    for(let ch of word2) {
        map2[ch.charCodeAt(0)-'a'.charCodeAt(0)]++;
    }
    let ans = true;
    let hMap = new Map();
    let hMap1 = new Map();
    for(let i=0; i<26; i++) {
        if((map1[i] > 0 && map2[i] == 0) || (map2[i] > 0 && map1[i] == 0)) return false;
        if(!hMap.has(map1[i])) hMap.set(map1[i], 0);
        hMap.set(map1[i], hMap.get(map1[i])+1);
        if(!hMap1.has(map2[i])) hMap1.set(map2[i], 0);
        hMap1.set(map2[i], hMap1.get(map2[i])+1);
    }
    for(let [key, value] of hMap) {
        if(!hMap1.has(key)) return false;
        if(value != hMap1.get(key)) return false;
    }
    return ans;
};