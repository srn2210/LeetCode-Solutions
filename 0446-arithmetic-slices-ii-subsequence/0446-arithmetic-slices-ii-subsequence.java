class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        Map<Integer, Integer>[] dp = new Map[nums.length];
        int ans = 0;
        for(int i=0; i<nums.length; i++) {
            dp[i] = new HashMap<Integer, Integer>();                // array of maps instead of 2D array for -ve number diff
            for(int j=0; j<i; j++) {
                long d = (long)nums[i] - (long)nums[j];             // case like x - (-y) = x + y where res goes out of int range
                if(d <= Integer.MIN_VALUE || d >= Integer.MAX_VALUE) continue;
                int diff = (int) d;
                int t1 = dp[i].getOrDefault(diff, 0);               // for repeated numbers; eg : 7, 7, 7
                int t2 = dp[j].getOrDefault(diff, 0);               // j loops through all values < i because of subsequnces 
                dp[i].put(diff, t1 + t2 + 1);                       // 1 is ignored in ans because that is a two element subsequence
                ans += t2;                                          // only t2 needs to be added as t1 is just for updating dp
            }
        }
        return ans;
    }
}