/**
 * @param {number[][]} intervals
 * @param {number[]} newInterval
 * @return {number[][]}
 */
var insert = function(intervals, newInterval) {
    let ans = [];
    let i=0;
    while(i < intervals.length && intervals[i][1] < newInterval[0]) ans.push(intervals[i++]);
    while(i < intervals.length && intervals[i][0] <= newInterval[1]) {
        newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
        newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
        i++;
    }
    ans.push(newInterval);
    while(i < intervals.length && intervals[i][0] > newInterval[1]) ans.push(intervals[i++]);
    return ans;
};