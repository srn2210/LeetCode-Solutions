class Solution {
    public int searchInsert(int[] nums, int target) {
        int lo = 0, hi = nums.length, mid = 0;
        while(lo < hi) {
            mid = (hi + lo) / 2;
            if(nums[mid] >= target) hi = mid;
            else lo = mid + 1;
        }
        return lo;
    }
}