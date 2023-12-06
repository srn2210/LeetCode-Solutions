/**
 * @param {number} n
 * @return {number}
 */
var totalMoney = function(n) {
    let prevMon = 0;
    let prevDay = 1;
    let ans = 0;
    let start = 0;
    while(start < n) {
        if(start % 7 === 0) {
            prevMon++;
            ans += prevMon;
            prevDay = prevMon;
        }
        else {
            prevDay++;
            ans += prevDay;
        }
        start++;
    }
    return ans;
};