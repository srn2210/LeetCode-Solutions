class Solution {
public:
    int mod = 1e9+7;
    int solve(int n, int x, int y, vector<vector<int>>& dp) {
        if(x > n || y > n) return 0;
        if(x == n && y == n) return 1;
        if(dp[x][y] != -1) return dp[x][y];
        long ans = 0;
        if(x == y) {
            ans += solve(n, x+1, y+1, dp);
            ans += solve(n, x+2, y+2, dp);
            ans += solve(n, x+2, y+1, dp);
            ans += solve(n, x+1, y+2, dp);
        }
        else if(x - y == 1) {
            ans += solve(n, x+1, y+2, dp);
            ans += solve(n, x, y+2, dp);
        }
        else {
            ans += solve(n, x+2, y+1, dp);
            ans += solve(n, x+2, y, dp);
        }
        return dp[x][y] = ans % mod;
    }
    int numTilings(int n) {
        vector<vector<int>> dp(n+1, vector<int>(n+1, -1));
        return solve(n, 0, 0, dp);
    }
};