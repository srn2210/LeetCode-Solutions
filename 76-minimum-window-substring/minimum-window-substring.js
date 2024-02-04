/**
 * @param {string} s
 * @param {string} t
 * @return {string}
 */
var minWindow = function(s, t) {
    let left = 0, right = 0;
    let ansLeft = -1, ansRight = -1;
    let count = 0;
    let arr = new Array(58).fill(0);
    for(let i=0; i<t.length; i++) {
        arr[t[i].charCodeAt(0)-'A'.charCodeAt(0)]++;
    }
    for(let i=0; i<58; i++) if(arr[i] > 0) count++;
    let currCount = new Array(58).fill(0);
    let ans = s.length;
    while(left <= right && right < s.length) {
        let r = s[right].charCodeAt(0) - 'A'.charCodeAt(0);
        currCount[r]++;
        if(currCount[r] === arr[r]) {
            count--;
        }         
        while(count === 0) {
            if(ans >= right - left + 1) {
                ansLeft = left;
                ansRight = right;
                ans = right - left + 1;
            }
            let l = s[left].charCodeAt(0) - 'A'.charCodeAt(0);
            currCount[l]--;
            if(currCount[l] + 1 === arr[l]) {
                count++;
            }
            left++;
        }        
        right++;
    }
    if(ansLeft === -1 && ansRight === -1) return '';
    return s.substring(ansLeft, ansRight+1);
};