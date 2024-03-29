class Solution {
    public int singleNonDuplicate(int[] nums) {
        if(nums.length == 1) return nums[0];
        int l = 0;
        int r = nums.length-1;
        while(l<=r) {
            int mid = l + (r-l) / 2;
            if(mid % 2 == 0) {
                if(mid + 1 < nums.length && nums[mid] == nums[mid+1]) {
                    l = mid + 1;
                }
                else r = mid-1;
            }
            else {
                if(mid + 1 < nums.length && nums[mid] == nums[mid+1]) {
                    r = mid - 1;
                }
                else l = mid+1;
            }
        }
        return nums[l];
    }
}