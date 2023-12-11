/**
 * @param {number[]} arr
 * @return {number}
 */
var findSpecialInteger = function(arr) {
    let prev = -1;
    let streak = 0;
    let ans = 0;
    for(let num of arr) {
        if(prev === num) streak++;
        else {
            if(streak > arr.length / 4) return prev;
            prev = num;
            streak = 1;
        }
    }
    if(streak != 0 && streak > arr.length / 4) {
        return prev;
    }
    return ans;
};