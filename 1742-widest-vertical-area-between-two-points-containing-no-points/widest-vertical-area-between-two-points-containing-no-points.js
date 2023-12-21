/**
 * @param {number[][]} points
 * @return {number}
 */
var maxWidthOfVerticalArea = function(points) {
    points.sort((a, b) => a[0] - b[0]);
    let ans = -1;
    for(let i=0; i<points.length-1; i++) {
        ans = Math.max(ans, points[i+1][0] - points[i][0]);
    }
    return ans;
};