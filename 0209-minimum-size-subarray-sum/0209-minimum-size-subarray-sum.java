class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int ans = nums.length + 1;
        int i=-1,j=0;
        while(i++<nums.length-1) {
            target -= nums[i];
            while(target <= 0) {
                ans = Math.min(ans, i-j+1);
                target += nums[j++];
            }
        }
        return ans == nums.length + 1 ? 0 : ans;
    }
}