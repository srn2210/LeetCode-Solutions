class Solution {
    void swap(int a, int b, int[] nums) {
        int t = nums[a];
        nums[a] = nums[b];
        nums[b] = t;
    }
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for(int i=0; i<n; i++) {
            while(nums[i] > 0 && nums[i] <= n && nums[i] != nums[nums[i]-1]) {
                swap(i, nums[i]-1, nums);
            }
        }
        for(int i=1; i<=n; i++) if(nums[i-1] != i) return i;
        return n+1;
    }
}