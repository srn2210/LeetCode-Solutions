class Solution {
    public int[] getAverages(int[] nums, int k) {
        int window = 2 * k + 1, n = nums.length;
        long curr = 0;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        if(window > n) return ans;
        for(int i=0; i<window-1; i++) curr += nums[i];
        for(int i=k; i<n-k; i++) {
            curr += nums[i+k];
            ans[i] = (int)(curr / window);
            curr -= nums[i-k];
        }
        return ans;
    }
}