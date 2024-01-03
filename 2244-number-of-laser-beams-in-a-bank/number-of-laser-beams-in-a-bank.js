/**
 * @param {string[]} bank
 * @return {number}
 */
var numberOfBeams = function(bank) {
    let prevCount = 0, ans = 0;
    for(let floor of bank) {
        let count = 0;
        for(let device of floor) {
            if(device === '1') count++;
        }
        ans += count * prevCount;
        if(count != 0) prevCount = count;
    } 
    return ans;
};