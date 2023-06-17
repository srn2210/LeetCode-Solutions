class Solution {
    long mod = (long)1e9 + 7;
    long[][] dp;

    public int numOfWays(int[] nums) {
        int m = nums.length;
        
        // Table of Pascal's triangle
        dp = new long[m][m];
        for(int i=0; i<m; i++) Arrays.fill(dp[i], -1);
        List<Integer> arrList = Arrays.stream(nums).boxed().collect(Collectors.toList());
        return (int)((dfs(arrList) - 1) % mod);
    }

    long calc(int left, int right) {
        if(left == 0 || right == 0) return 1;
        if(dp[left][right] != -1) return dp[left][right];
        return dp[left][right] = (calc(left-1, right) + calc(left, right-1)) % mod;
    }

    long dfs(List<Integer> nums) {
        int m = nums.size();
        if (m < 3) {
            return 1;
        }

        List<Integer> leftNodes = new ArrayList<>();
        List<Integer> rightNodes = new ArrayList<>();
        for (int i = 1; i < m; ++i) {
            if (nums.get(i) < nums.get(0)) {
                leftNodes.add(nums.get(i));
            } else {
                rightNodes.add(nums.get(i));
            }
        }
        long leftWays = dfs(leftNodes) % mod;
        long rightWays = dfs(rightNodes) % mod;

        return (((leftWays * rightWays) % mod) * calc(leftNodes.size(), rightNodes.size())) % mod;
    }
}