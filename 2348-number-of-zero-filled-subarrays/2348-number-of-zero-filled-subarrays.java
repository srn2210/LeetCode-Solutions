class Solution {
    public long zeroFilledSubarray(int[] nums) {
        int l = 0;
        int r = 0;
        long ans = 0;
        while(r < nums.length) {
            if(nums[r] == 0) r++;
            else {
                l = ++r;
            }
            ans += r-l;
        }
        return ans;
    }
}