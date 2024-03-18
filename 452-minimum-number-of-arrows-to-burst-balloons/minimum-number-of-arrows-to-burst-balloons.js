/**
 * @param {number[][]} points
 * @return {number}
 */
var findMinArrowShots = function(points) {
    points.sort((a,b) => a[0] === b[0] ? a[1] - b[1] : a[0] - b[0]);
    let last = [points[0][0], points[0][1]];
    let count = 1;
    for(let point of points) {
        if(last[1] >= point[0]) {
            last[0] = Math.max(point[0], last[0]);
            last[1] = Math.min(point[1], last[1]);
        }
        else {
            last = point;
            count++;
        }
    }
    return count;
};