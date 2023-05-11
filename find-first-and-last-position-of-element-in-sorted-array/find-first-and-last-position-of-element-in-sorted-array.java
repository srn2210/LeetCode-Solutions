class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0) return new int[]{-1,-1};
        int lo = 0, hi = nums.length-1, mid = 0;
        int[] ans = new int[2];
        while(lo < hi) {
            mid = lo + (hi - lo) / 2;
            if(nums[mid] >= target) hi = mid;
            else lo = mid + 1;
        }
        ans[0] = nums[lo] == target ? lo : -1;
        if(ans[0] == -1) return new int[]{-1,-1};
        lo = 0; hi = nums.length-1;
        while(lo < hi) {
            mid = lo + (hi - lo) / 2;
            if(nums[mid] > target) hi = mid - 1;
            else lo = mid + 1;
        }
        ans[1] = nums[lo] != target ? lo-1 : lo;
        return ans;
    }
}