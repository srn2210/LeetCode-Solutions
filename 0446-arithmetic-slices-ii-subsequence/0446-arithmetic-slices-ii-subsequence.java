class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        Map<Integer, Integer>[] dp = new Map[nums.length];
        int ans = 0;
        for(int i=0; i<nums.length; i++) {
            dp[i] = new HashMap<Integer, Integer>();
            for(int j=0; j<i; j++) {
                long d = (long)nums[i] - (long)nums[j];
                if(d <= Integer.MIN_VALUE || d >= Integer.MAX_VALUE) continue;
                int diff = (int) d;
                int t1 = dp[i].getOrDefault(diff, 0);
                int t2 = dp[j].getOrDefault(diff, 0);
                dp[i].put(diff, t1 + t2 + 1);
                ans += t2;
            }
        }
        return ans;
    }
}