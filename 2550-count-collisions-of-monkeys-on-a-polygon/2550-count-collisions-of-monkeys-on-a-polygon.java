class Solution {
    int mod = (int) 1e9+7;
    long solve(int n) {
        if(n == 1) return 2;
        else if(n % 2 == 0) {
            var ans = solve(n/2);
            ans = ans * ans % mod;
            return ans % mod;
        }
        else {
            var ans = solve(n/2);
            ans = ans * ans % mod;
            ans = ans * 2 % mod;
            return ans % mod;
        }
    }
    public int monkeyMove(int n) {
        var ans = solve(n);
        ans -= 2;
        return ans < 0 ? (int)ans + mod : (int)ans;
    }
}