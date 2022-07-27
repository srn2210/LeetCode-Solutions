class Solution {
    public int wiggleMaxLength(int[] nums) {
        if(nums.length == 1) return 1;
        int up = 1;
        int down = 1;
        
        for(int i=1; i<nums.length; i++){
            if(nums[i] < nums[i-1]) down = up + 1;
            else if(nums[i] > nums[i-1]) up = down + 1;
            else continue;
        }
        
        return Math.max(up, down);
    }
}