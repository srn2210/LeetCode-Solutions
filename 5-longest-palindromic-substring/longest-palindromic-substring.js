/**
 * @param {string} s
 * @return {string}
 */
var longestPalindrome = function(s) {
    maxLen = 0
    maxStart = 0
    maxEnd = 0

    function iterateInner(left, right) {
        while(left >= 0 && right < s.length) {
            if(s[left] === s[right]) {
                if(right - left + 1 > maxLen) {
                    maxLen = right - left + 1
                    maxStart = left
                    maxEnd = right
                }
            }
            else break
            left--
            right++
        }
    }

    for(let i=0; i<s.length; i++) {
        left = i-1
        right= i+1
        iterateInner(left, right)
    }
    for(let i=1; i<s.length; i++) {
        left = i-1
        right= i
        iterateInner(left, right)
    }
    return s.substring(maxStart, maxEnd+1)
};