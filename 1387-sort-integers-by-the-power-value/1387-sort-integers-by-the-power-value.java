class Solution {
    static int[][] dp;
    int solve(int x){
        int ans = 0;
        if( x < dp.length && dp[x][1] != -1){
            return dp[x][1];
        }
        else if( x % 2 == 0){
            int y = x / 2;
            ans = solve(y) + 1;
            if( x < dp.length ) {
                dp[x][1] = ans;
            }
        }
        else {
            int y = (3 * x) + 1;
            ans = solve(y) + 1;
            if( x < dp.length )
                dp[x][1] = solve(y) + 1;
        }
        return ans;
    }
    public int getKth(int lo, int hi, int k) {
        dp = new int[hi+1][2];
        
        for(int[] i:dp){
            Arrays.fill(i, -1);
        }
        
        for(int i=0; i<dp.length; i++){
            dp[i][0] = i;
        }
        
        
        int j = 1;
        int m = 0;
        
        do{
            dp[j][1] = m;
            m++;
            j = (int)Math.pow(2, m);
        }while(j < hi);
        
        for( int i=lo; i<=hi; i++ ){
            if( i == 1 ) continue;
            else {
                dp[i][1] = solve(i);
            }
        }
                
        Arrays.sort(dp, lo, hi+1, (a,b) -> a[1] - b[1]);
        
        return dp[lo+k-1][0];
    }
}