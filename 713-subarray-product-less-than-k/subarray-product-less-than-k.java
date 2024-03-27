class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k == 0) return 0;
        int left = 0, right = 0;
        int prod = 1, ans = 0;
        while(right < nums.length) {
            prod *= nums[right++];
            ans += right-left;
            int count = 0;
            while(left < nums.length && left < right && prod >= k) {
                prod /= nums[left++];
                count++;
            }
            ans -= count;
        }
        return ans;
    }
}