class Solution {
    public int rob(int[] nums) {
        int x = 0, y = 0, ans = 0;
        for(int i=0; i<nums.length; i++) {
            ans = Math.max(y, x + nums[i]);
            x = y;
            y = ans;
        }
        return ans;
    }
}