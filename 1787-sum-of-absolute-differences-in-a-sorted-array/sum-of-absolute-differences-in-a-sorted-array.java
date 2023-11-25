class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int[] pre = new int[n];
        int[] post = new int[n];
        int[] ans = new int[n];
        for(int i=1; i<n; i++) {
            pre[i] = pre[i-1] + nums[i-1];
        }
        for(int i=n-2; i>=0; i--) {
            post[i] = post[i+1] + nums[i+1];
        }
        for(int i=0; i<n; i++) {
            int left = (nums[i] * i) - pre[i];
            int right = post[i] - ((n - i - 1) * nums[i]);
            ans[i] = left + right;
        }
        return ans;
    }
}