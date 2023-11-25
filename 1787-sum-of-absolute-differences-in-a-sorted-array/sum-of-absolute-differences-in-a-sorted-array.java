class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int total = 0, pre = 0;
        for(int num : nums) total += num;
        for(int i=0; i<n; i++) {
            int left = (nums[i] * i) - pre;
            int right = total - pre - nums[i] - ((n - i - 1) * nums[i]);
            ans[i] = left + right;
            pre += nums[i];
        }
        return ans;
    }
}