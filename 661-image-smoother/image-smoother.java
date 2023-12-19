class Solution {
    public int[][] imageSmoother(int[][] img) {
        int m = img.length, n = img[0].length;
        int[][] ans = new int[m][n];
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                int total = 0;
                int count = 0;
                for(int a=-1; a<=1; a++) {
                    for(int b=-1; b<=1; b++) {
                        int row = a + i;
                        int col = b + j;
                        if(row < 0 || col < 0 || row >= m || col >= n) continue;
                        total += img[row][col];
                        count++;
                    }
                }
                ans[i][j] = total / count;
            }
        }
        return ans;
    }
}