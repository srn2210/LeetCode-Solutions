class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length-1;
        while(left < right) {
            int mid = left + (right - left) / 2;
            if(nums[left] <= nums[mid]) {
                if(target > nums[mid] || target < nums[left]) left = mid + 1;
                else right = mid;
            }
            else {
                if(target < nums[mid] || target > nums[right]) right = mid - 1;
                else left = mid;
            }
        }
        //System.out.println(left);
        return nums[left] == target ? left : -1;
    }
}