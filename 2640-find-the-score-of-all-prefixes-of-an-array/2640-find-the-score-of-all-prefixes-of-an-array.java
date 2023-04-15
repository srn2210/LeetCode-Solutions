class Solution {
    public long[] findPrefixScore(int[] nums) {
        long conv = 0;
        long max = Integer.MIN_VALUE;
        long[] ans = new long[nums.length];
        for(int i=0; i<nums.length; i++) {
            max = Math.max(max, nums[i]);
            conv += max + nums[i];
            ans[i] = conv;
        }
        return ans;
    }
}