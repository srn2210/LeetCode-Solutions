class Solution {
    public int minimumDeletions(int[] nums) {
        int min_idx = 0, max_idx = 0;
        for(int i=0; i<nums.length; i++) {
            if(nums[i] < nums[min_idx]) min_idx = i;
            if(nums[i] > nums[max_idx]) max_idx = i;
        }
        int allLeft = Math.max(min_idx, max_idx)+1, allRight = nums.length - Math.min(min_idx, max_idx);
        return Math.min(Math.min(allLeft, allRight), Math.min(min_idx, max_idx)+1 + nums.length - Math.max(min_idx, max_idx));
    }
}