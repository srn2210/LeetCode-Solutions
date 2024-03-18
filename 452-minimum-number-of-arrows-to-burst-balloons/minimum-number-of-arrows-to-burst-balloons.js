/**
 * @param {number[][]} points
 * @return {number}
 */
var findMinArrowShots = function(points) {
    points.sort((a,b) => a[0] === b[0] ? a[1] - b[1] : a[0] - b[0]);
    let arr = [];
    for(let point of points) {
        if(arr.length === 0) arr.push(point);
        else {
            if(arr[arr.length-1][1] >= point[0]) {
                arr[arr.length-1][0] = Math.max(point[0], arr[arr.length-1][0]);
                arr[arr.length-1][1] = Math.min(point[1], arr[arr.length-1][1]);
            }
            else arr.push(point);
        }
    }
    return arr.length;
};