class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        //int[][] ans = new int[n][n];
        int[][] pre = new int[n][n];
        for(int[] query : queries) {
            for(int i=query[0]; i<=query[2]; i++) {
                pre[i][query[1]] += 1;
                if(query[3] + 1 < n) pre[i][query[3]+1] -= 1;
            }
        }
        for(int i=0; i<n; i++) {
            for(int j=1; j<n; j++) {
                pre[i][j] += pre[i][j-1];
            }
        }
        return pre;
    }
}