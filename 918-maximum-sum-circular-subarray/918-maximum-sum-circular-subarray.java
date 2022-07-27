class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        if(nums.length == 1) return nums[0];
        
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int sum = 0;
        int tot = 0;
        
        for(int i:nums){
            tot += i;
            sum += i;
            max = Math.max(max, sum);
            sum = Math.max(sum, 0);
        }
        
        sum = 0;
        
        for(int i:nums){
            sum += i;
            min = Math.min(min, sum);
            sum = Math.min(sum, 0);
        }
        
        if(tot-min == 0) return max;
        
        max = Math.max(max, tot-min);
        
                
        return max;
    }
}