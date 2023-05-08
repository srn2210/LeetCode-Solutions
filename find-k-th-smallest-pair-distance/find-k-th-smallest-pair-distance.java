class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int lo = 0, hi = nums[nums.length-1] - nums[0];
        while(lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int count = 0;
            int left = 0, right = 1;
            while(right < nums.length) {
                if(nums[right] - nums[left] <= mid) {
                    count += right - left;
                    right++;
                }
                else left++;
            }
            if(count >= k) hi = mid;
            else lo = mid + 1;
        }
        return lo;
    }
}