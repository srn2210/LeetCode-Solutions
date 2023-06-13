class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length-1, ans = 0;
        while(left < right) {
            int mid = left + (right - left) / 2;
            if(nums[left] == nums[right]) left = left + 1;
            else if(nums[mid] <= nums[right]) right = mid;
            else left = mid + 1;
        }
        return nums[left];
    }
}