class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int[] arr = new int[nums.length+1];
        int ans = 100001;
        for(int i=0; i<nums.length; i++) arr[i+1] = nums[i] + arr[i];
        nums = arr;
        for(int i=1; i<nums.length; i++) {
            int complement = nums[i-1] + target;
            int left = i, right = nums.length-1;
            while(left < right) {
                int mid = left + (right - left) / 2;
                if(nums[mid] < complement) left = mid + 1;
                else right = mid;
            }
            if(nums[left] - nums[i-1] >= target) ans = Math.min(ans, left-i+1);
        }
        return ans == 100001 ? 0 : ans;
    }
}