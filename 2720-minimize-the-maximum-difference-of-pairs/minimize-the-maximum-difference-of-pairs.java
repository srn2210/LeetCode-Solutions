class Solution {
    boolean safe(int cand, int[] nums, int p) {
        int count = 0;
        for(int i=0; i<nums.length-1; i++) {
            if(Math.abs(nums[i] - nums[i+1]) <= cand) {
                count++;
                i++;
            }
        }
        return count >= p;
    }
    public int minimizeMax(int[] nums, int p) {
        int left = 0, right = (int)1e9;
        Arrays.sort(nums);
        while(left < right) {
            int mid = left + (right - left) / 2;
            if(safe(mid, nums, p)) right = mid;
            else left = mid + 1;
        }
        return left;
    }
}