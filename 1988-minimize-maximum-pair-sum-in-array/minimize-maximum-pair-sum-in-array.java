class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int max = 0, left = 0, right = nums.length-1;
        while(left < right) max = Math.max(max, nums[left++] + nums[right--]);
        return max;
    }
}