class Solution {
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        int count = 1, startx = 0, endx = n-1, starty = 0, endy = n-1;
        int total = n * n;
        while(count <= total) {
            for(int i=starty; count <= total && i<=endy; i++) {
                ans[startx][i] = count++;
            }
            startx++;
            for(int i=startx; count <= total && i<=endx; i++) {
                ans[i][endy] = count++;
            }
            endy--;
            for(int i=endy; count <= total && i>=starty; i--) {
                ans[endx][i] = count++;
            }
            endx--;
            for(int i=endx; count <= total && i>=startx; i--) {
                ans[i][starty] = count++;
            }
            starty++;
        }
        return ans;
    }
}