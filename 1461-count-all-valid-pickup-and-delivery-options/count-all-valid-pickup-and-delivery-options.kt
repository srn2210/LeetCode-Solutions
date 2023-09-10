class Solution {
    fun countOrders(n: Int) = Array(n + 1) { (IntArray(n + 1)) }.let { dp ->
        val mod = 1_000_000_007
        dp[0][0] = 1
        fun solve(p: Int, d: Int): Int =
            dp[p][d].takeIf { it != 0 } ?: ((if (d == 0) p.toLong() * solve(p - 1, 1)
            else if (p == 0) d.toLong() * solve(p, d - 1)
            else p.toLong() * solve(p - 1, d + 1) + d.toLong() * solve(p, d - 1)) % mod).toInt()
                .also { dp[p][d] = it }
        solve(n, 0)
    }
}