class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int lo = 0, hi = nums[nums.length-1] - nums[0];
        while(lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int count = 0;
            for(int i=0; i<nums.length-1; i++) {
                for(int j=i+1; j<nums.length; j++) {
                    if(Math.abs(nums[i] - nums[j]) > mid) break;
                    count++;
                }
            }
            if(count >= k) hi = mid;
            else lo = mid + 1;
        }
        return lo;
    }
}