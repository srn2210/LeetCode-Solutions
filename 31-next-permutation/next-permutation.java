class Solution {
    public void nextPermutation(int[] nums) {
        for(int i=nums.length-2; i>=0; i--) {
            if(nums[i] < nums[i+1]) {
                int justLarger = 0;
                for(int j=nums.length-1; j>=0; j--) {
                    if(nums[j] > nums[i]) {
                        justLarger = j;
                        break;
                    }
                }
                int t = nums[i];
                nums[i] = nums[justLarger];
                nums[justLarger] = t;
                int left = i+1, right = nums.length-1;
                while(left < right) {
                    int tt = nums[left];
                    nums[left] = nums[right];
                    nums[right] = tt;
                    left++;
                    right--;
                }
                return;
            }
            else continue;
        }
        Arrays.sort(nums);
    }
}