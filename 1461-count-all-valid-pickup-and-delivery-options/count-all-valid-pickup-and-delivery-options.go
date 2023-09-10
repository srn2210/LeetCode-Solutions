var mod = 1000000007

func solve(pick, del, total int, dp [][]int) int {
	if pick == total && del == 0 {
		return 1
	}
	if dp[pick][del] != -1 {
		return dp[pick][del]
	}

	var ans int
	remPick := total - pick

	if remPick > 0 {
		ans += remPick * solve(pick+1, del+1, total, dp)
		ans %= mod
	}

	if del > 0 {
		ans += del * solve(pick, del-1, total, dp)
		ans %= mod
	}

	dp[pick][del] = ans
	return ans
}

func countOrders(n int) int {
	dp := make([][]int, n+1)
	for i := range dp {
		dp[i] = make([]int, n+1)
		for j := range dp[i] {
			dp[i][j] = -1
		}
	}
	return solve(0, 0, n, dp)
}