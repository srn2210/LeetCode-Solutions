/**
 * @param {number[][]} img
 * @return {number[][]}
 */
var imageSmoother = function(img) {
    let m = img.length, n = img[0].length;
    let ans = new Array(m);
    for(let i=0; i<m; i++) ans[i] = new Array(n).fill(0);
    for(let i=0; i<m; i++) {
        for(let j=0; j<n; j++) {
            let total = 0;
            let count = 0;
            for(let a=-1; a<=1; a++) {
                for(let b=-1; b<=1; b++) {
                    let row = a + i;
                    let col = b + j;
                    if(row < 0 || col < 0 || row >= m || col >= n) continue;
                    total += img[row][col];
                    count++;
                }
            }
            ans[i][j] = (total - (total % count)) / count;
        }
    }
    return ans;
};