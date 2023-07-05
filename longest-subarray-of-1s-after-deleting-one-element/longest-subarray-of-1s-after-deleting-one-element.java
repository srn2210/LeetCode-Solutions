class Solution {
    public int longestSubarray(int[] nums) {
        int right = 0, left = 0, max = 0, next = 0;
        boolean flag = false;
        while(right < nums.length) {
            if(flag && nums[right] == 0) {
                left = next+1;
                next = right;
            }
            else if(nums[right] == 0) {
                flag = true;
                next = right;
            }
            max = Math.max(right-left, max);
            right++;
        }
        return max;
    }
}