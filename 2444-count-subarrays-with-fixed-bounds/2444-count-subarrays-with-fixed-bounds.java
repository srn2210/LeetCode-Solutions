class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long ans = 0;
        int minP = -1, maxP = -1, leftBound = -1;
        for(int i=0; i<nums.length; i++) {
            if(nums[i] < minK || nums[i] > maxK) leftBound = i;
            if(nums[i] == minK) minP = i;
            if(nums[i] == maxK) maxP = i;
            ans += Math.max(0, Math.min(minP, maxP) - leftBound);
        }
        return ans;
    }
}