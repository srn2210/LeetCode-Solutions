class Solution {
    public int maxProduct(int[] nums) { 
        int maxp = 1;
        int minp = 1;
        int ans = Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++) {
            int temp = maxp;
            maxp = Math.max(nums[i], nums[i] >=0 ? maxp * nums[i] : minp * nums[i]);
            minp = Math.min(nums[i], nums[i] >=0 ? minp * nums[i] : temp * nums[i]);
            ans = Math.max(maxp, ans);
        }
        return ans;
    }
}