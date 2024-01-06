/**
 * @param {number[]} startTime
 * @param {number[]} endTime
 * @param {number[]} profit
 * @return {number}
 */
var jobScheduling = function(startTime, endTime, profit) {
    let arr = [];
    let n = startTime.length;
    let dp = new Map();
    for(let i=0; i<n; i++) {
       arr.push([startTime[i], endTime[i], profit[i]]);
    }
    arr.sort((a,b) => a[0] - b[0] === 0 ? a[1] - b[1] : a[0] - b[0]);

    function search(target) {
        let left = 0, right = n;
        while(left < right) {
            let mid = Math.floor((left + right) / 2);
            if(arr[mid][0] >= target) right = mid;
            else left = mid + 1;
        }
        return left;
    }

    function solve(idx) {
        if(idx == n) return 0;
        if(dp.has(idx)) return dp.get(idx);
        let res = 0;
        let next = search(arr[idx][1]);
        res = Math.max(res, arr[idx][2] + solve(next));
        res = Math.max(res, solve(idx+1));
        dp.set(idx, res);
        return res;
    }
    
    return solve(0);
};