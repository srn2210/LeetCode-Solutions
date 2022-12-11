class Solution {
    void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    public void sortColors(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while(left < right) {
            if(nums[right] == 2) {
                right--;
                continue;
            }
            else if(nums[left] == 0) {
                left++;
                continue;
            }
            else {
                swap(nums, left, right);
                if(nums[right] == 2) right--;
                if(nums[left] != 2) left++;
            }
        }
        left = 0;
        while(left < right) {
            if(nums[right] == 2) {
                right--;
                continue;
            }
            else if(nums[left] == 0) {
                left++;
                continue;
            }
            else {
                swap(nums, left, right);
                if(nums[right] != 0) right--;
                if(nums[left] == 0) left++;
            }
        }
    }
}