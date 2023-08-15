class Solution {
    public void nextPermutation(int[] nums) {
        for(int i=nums.length-2; i>=0; i--) {
            if(nums[i] < nums[i+1]) {
                int left = i+1, right = nums.length-1;
                while(left < right) {
                    int tt = nums[left];
                    nums[left] = nums[right];
                    nums[right] = tt;
                    left++;
                    right--;
                }
                for(int j=i+1; j<nums.length; j++) {
                    if(nums[j] > nums[i]) {
                        int t = nums[i];
                        nums[i] = nums[j];
                        nums[j] = t;
                        break;
                    }
                }                
                return;
            }
        }
        Arrays.sort(nums);
    }
}