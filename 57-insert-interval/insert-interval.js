/**
 * @param {number[][]} intervals
 * @param {number[]} newInterval
 * @return {number[][]}
 */
var insert = function(intervals, newInterval) {
    intervals.push(newInterval);
    intervals.sort((a,b) => a[0]===b[0] ? a[1]-b[1] : a[0]-b[0]);
    let ans = [];
    for(let interval of intervals) {
        if(ans.length === 0) ans.push(interval);
        else {
            if(ans[ans.length-1][1] >= interval[0]) {
                ans[ans.length-1][0] = Math.min(ans[ans.length-1][0], interval[0]);
                ans[ans.length-1][1] = Math.max(ans[ans.length-1][1], interval[1]);
            }
            else ans.push(interval);
        }
    }
    return ans;
};