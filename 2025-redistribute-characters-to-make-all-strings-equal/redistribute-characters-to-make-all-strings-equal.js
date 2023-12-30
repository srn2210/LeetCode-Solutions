/**
 * @param {string[]} words
 * @return {boolean}
 */
var makeEqual = function(words) {
    let arr = new Array(26).fill(0);
    for(let word of words) {
        for(let ch of word) {
            arr[ch.charCodeAt(0)-'a'.charCodeAt(0)]++;
        }
    }
    let len = words.length;
    for(let freq of arr) {
        if(freq % len !== 0) return false;
    }
    return true;
};