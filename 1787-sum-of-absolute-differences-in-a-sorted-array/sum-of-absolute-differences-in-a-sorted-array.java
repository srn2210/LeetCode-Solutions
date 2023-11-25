class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int[] pre = new int[n];
        int[] ans = new int[n];
        int total = nums[0];
        for(int i=1; i<n; i++) {
            pre[i] = pre[i-1] + nums[i-1];
            total += nums[i];
        }
        for(int i=0; i<n; i++) {
            int left = (nums[i] * i) - pre[i];
            int right = total - pre[i] - nums[i] - ((n - i - 1) * nums[i]);
            ans[i] = left + right;
        }
        return ans;
    }
}