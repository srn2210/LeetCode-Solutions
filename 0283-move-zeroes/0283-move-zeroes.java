class Solution {
    public void moveZeroes(int[] nums) {
        int j = 0;
        for(int i=0; i<nums.length; i++) {
            if (nums[j] == 0 && nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }
            else if (nums[j] != 0) {
                j++;
            }
        }
    }
}