/**
 * @param {string} s
 * @return {boolean}
 */
var halvesAreAlike = function(s) {
    let st = 0, ed = s.length/2;
    let count = 0;

    function isVowel(ch) {
        return ch === 'a' || ch === 'e' || ch === 'i' || ch === 'o' || ch === 'u' || ch === 'A' || ch === 'E' || ch === 'I' || ch === 'O' || ch === 'U';
    }

    while(ed < s.length) {
        if(isVowel(s[st])) count++;
        if(isVowel(s[ed])) count--;
        st++;
        ed++;
    }
    return count === 0;
};