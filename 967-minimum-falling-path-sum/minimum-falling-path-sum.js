/**
 * @param {number[][]} matrix
 * @return {number}
 */
var minFallingPathSum = function(matrix) {
    let max = 1e9;
    let m = matrix.length, n = matrix[0].length;
    for(let i=1; i<m; i++) {
        for(let j=0; j<n; j++) {
            let prev = matrix[i-1][j];
            let prevLeft = j-1 >= 0 ? matrix[i-1][j-1] : max;
            let prevRight = j+1 < n ? matrix[i-1][j+1] : max;
            let min = Math.min(prev, prevLeft);
            min = Math.min(min, prevRight);
            matrix[i][j] += min;
        }
    }
    let ans = max;
    for(let num of matrix[m-1]) {
        ans = Math.min(ans, num);
    }
    return ans;
};