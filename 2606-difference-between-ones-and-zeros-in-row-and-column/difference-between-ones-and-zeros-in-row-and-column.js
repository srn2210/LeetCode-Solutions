/**
 * @param {number[][]} grid
 * @return {number[][]}
 */
var onesMinusZeros = function(grid) {
    let m = grid.length, n = grid[0].length;
    let row = new Array(m).fill(0);
    let col = new Array(n).fill(0);
    let diff = new Array(m);
    for(let i=0; i<m; i++) {
        for(let j=0; j<n; j++) {
            row[i] += grid[i][j];
            col[j] += grid[i][j];
        }
        diff[i] = new Array(n);
    }
    
    for(let i=0; i<m; i++) {
        for(let j=0; j<n; j++) {
            diff[i][j] = row[i] + col[j] - m + row[i] - n + col[j];
        }
    }
    return diff;
};