class Solution {
    public List<Integer> getRow(int rowIndex) {
        int[][] dp = new int[rowIndex+1][rowIndex+1];
        if(rowIndex == 0){
            List<Integer> l = new ArrayList<>(List.of(1));
            return l;
        }
        for(int i=0; i<dp.length; i++){
            dp[i][0] = 1;
            dp[0][i] = 1;
        }
        dp[0][0] = 0;
        for(int i=1; i<dp.length; i++){
            for(int j=1; j<dp[i].length; j++){
                if(i == j){
                    dp[i][j] = 1;
                    continue;
                }
                dp[i][j] = dp[i-1][j] + dp[i-1][j-1];
            }
        }
        List<Integer> l = new ArrayList<>();
        for(int i=0; i<dp.length; i++){
            l.add(dp[rowIndex][i]);
        }
        return l;
    }
}