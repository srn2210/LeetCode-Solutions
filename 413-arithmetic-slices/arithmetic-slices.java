class Solution {
    int calc(int num) {
        num -= 2;
        return (num * (num+1)) / 2;
    }
    public int numberOfArithmeticSlices(int[] nums) {
        int ans = 0, n = nums.length;
        if(n <= 2) return 0;
        int left = 0, right = 1, diff = nums[right] - nums[left];
        while(right < n) {
            if(right+1 < n && nums[right+1] - nums[right] == diff) {
            }
            else {
                if(right - left + 1 >= 3) {
                    ans += calc(right-left+1);
                }
                left = right;
                if(right +1 < n) diff = nums[right+1] - nums[right];
            }
            right++;
        }
        return ans;
    }
}