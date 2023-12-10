/**
 * @param {number[][]} matrix
 * @return {number[][]}
 */
var transpose = function(matrix) {
    let ans = new Array(matrix[0].length);
    for(let i=0; i<ans.length; i++) {
        ans[i] = new Array(matrix.length).fill(0);
    }
    for(let i=0; i<matrix.length; i++) {
        for(let j=0; j<matrix[0].length; j++) {
            ans[j][i] = matrix[i][j];
        }
    }
    return ans;
};