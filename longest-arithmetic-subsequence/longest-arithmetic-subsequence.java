class Solution {
    public int longestArithSeqLength(int[] nums) {
        int[][] arr = new int[1001][1002];
        for(int i=0; i<nums.length; i++) {
            for(int j=0; j<i; j++) {
                int diff = nums[i] - nums[j] + 500;
                arr[i][diff] = arr[j][diff] + 1;
            }
        }
        int ans = -1;
        for(var a : arr) {
            for(var val : a) {
                ans = Math.max(ans, val);
            }
        }
        return ans + 1;
    }
}