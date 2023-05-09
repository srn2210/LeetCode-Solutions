class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int startx = 0, starty = 0, endx = m-1, endy = n-1;
        var ans = new ArrayList<Integer>();
        while(startx <= endx && starty <= endy) {
            for(int i=starty; i<=endy; i++) {
                ans.add(matrix[startx][i]);
            }
            startx++;
            for(int i=startx; i<=endx; i++) {
                ans.add(matrix[i][endy]);
            }
            endy--;
            if(endx < startx) break;
            if(endy < starty) break;
            for(int i=endy; i>=starty; i--) {
                ans.add(matrix[endx][i]);
            }
            endx--;
            for(int i=endx; i>=startx; i--) {
                ans.add(matrix[i][starty]);
            }
            starty++;
        }
        return ans;
    }
}