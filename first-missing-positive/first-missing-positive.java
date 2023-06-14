class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length, rep = 0;
        for(int i=0; i<n; i++) {
            if(nums[i] > 0) {
                rep = nums[i];
                break;
            }
        }
        //System.out.println(Arrays.toString(nums));
        for(int i=0; i<n; i++) if(nums[i] <= 0) nums[i] = rep;
        //System.out.println(Arrays.toString(nums));
        for(int i=0; i<n; i++) {
            int val = Math.abs(nums[i]);
            if(val != 0 && val <= n && nums[val-1] > 0) nums[val-1] = -1 * nums[val-1];
        }
        //System.out.println(Arrays.toString(nums));
        for(int i=0; i<n; i++) {
            if(nums[i] >= 0) return i+1;
        }
        return n+1;
    }
}