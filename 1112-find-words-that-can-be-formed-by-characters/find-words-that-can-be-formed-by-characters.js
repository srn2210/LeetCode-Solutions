/**
 * @param {string[]} words
 * @param {string} chars
 * @return {number}
 */
var countCharacters = function(words, chars) {
    let alpha = 'abcdefghijklmnopqrstuvwxyz';
    let count = function(word) {
        let map = new Map();
        for(let c of alpha) map.set(c, 0);
        for(let ch of word) {
            map.set(ch, map.get(ch)+1);
        }
        return map;
    }
    
    let dict = count(chars);
    let ans = 0;
    for(let word of words) {
        let curr = count(word);
        let flag = true;
        for(let i of alpha) {
            if(curr.get(i) > dict.get(i)) {
                flag = false;
                break;
            }
        }
        if(flag) ans += word.length;
    }
    return ans;
};