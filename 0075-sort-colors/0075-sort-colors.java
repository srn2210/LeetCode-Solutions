class Solution {
    void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    public void sortColors(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        while(mid <= right) {
            if(nums[mid] == 2) {
                swap(nums, mid, right--);
            }
            else if(nums[mid] == 0) {
                swap(nums, mid++, left++);
            }
            else {
                swap(nums, left, mid++);
            }
        }
    }
}