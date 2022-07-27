class Solution {
    public boolean increasingTriplet(int[] nums) {
        if(nums.length < 3) return false;
        
        int min = nums[0];
        int max1 = Integer.MIN_VALUE;
        int max2 = nums[nums.length-1];
        
        for(int i=0; i<nums.length-1; i++){
            if(min < nums[i]){
                if(max2 > nums[i] || (max1 != Integer.MIN_VALUE && nums[i] > max1)) return true;
                if( (max1 == Integer.MIN_VALUE && nums[i] > min) || (max1 != Integer.MIN_VALUE && nums[i] < max1) ) max1 = nums[i];
            }
            else if(nums[i] < min) min = nums[i];
        }
        
        return false;
    }
}