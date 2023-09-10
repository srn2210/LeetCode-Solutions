class Solution {
  final int mod = 1000000007;

  int countOrders(int n) {
    List<List<int>> dp = List.generate(n + 1, (_) => List<int>.filled(n + 1, -1));
    return solve(0, 0, n, dp);
  }

  int solve(int pick, int del, int total, List<List<int>> dp) {
    if (pick == total && del == 0) return 1;
    if (dp[pick][del] != -1) return dp[pick][del];

    int ans = 0;
    int remPick = total - pick;

    if (remPick > 0) {
      ans += remPick * solve(pick + 1, del + 1, total, dp);
      ans %= mod;
    }

    if (del > 0) {
      ans += del * solve(pick, del - 1, total, dp);
      ans %= mod;
    }

    dp[pick][del] = ans;
    return ans;
  }
}