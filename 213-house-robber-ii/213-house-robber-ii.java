class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        else if(nums.length == 2){
            return Math.max(nums[0], nums[1]);
        }
        else if(nums.length == 3){
            int temp = Math.max(nums[0], nums[1]);
            return Math.max(temp, nums[2]);
        }
        else if(nums.length == 4){
            return Math.max(nums[0]+nums[2], nums[1]+nums[3]);
        }
        int max1=0, max2=0;
        int[] nums1 = new int[nums.length];
        System.arraycopy(nums,0,nums1,0,nums.length);
        for(int i=3; i<nums.length-1; i++){
            if(i == 3) {
                nums[2] = nums[0] + nums[2];
                max1 = Math.max(nums[2], nums[1]);
            }
            nums[i] = nums[i] + Math.max(nums[i-2], nums[i-3]);
            if(nums[i] > max1){
                max1 = nums[i];
            }
        }
        for(int i=4; i<nums.length; i++){
            if(i == 4) {
                nums1[3] = nums1[1] + nums1[3];
                max2 = Math.max(nums1[3], nums1[2]);
            }
            nums1[i] = nums1[i] + Math.max(nums1[i-2], nums1[i-3]);
            if(nums1[i] > max2){
                max2 = nums1[i];
            }
        }
        return Math.max(max1, max2);
    }
}