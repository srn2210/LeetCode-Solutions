class Solution {
    public int[] sortArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }
    
    private void quickSort(int[] nums, int start, int end) {
        if (start >= end) return;
        
        int left = start, right = end;
		// Ideally, numbers are approximately increasing, which means the middle number is most likey the median number. 
		// The closer pivot is to the median number, the less swapping and recursion we need to do.
        int pivot = nums[left + (right - left) / 2];
        // with (left <= right), we can end with: 
		// 1. x, x, x, right, left, x, x, x,
		// or
		// 2. x, x, x, right, pivot, left, x, x, x
		// easy to divide without boundary issues
        while (left <= right) {
			// if we put nums[left] <= pivot, for array like [2, 1], 1 swap with itself and leads to dead loop
            while (left <= right && nums[left] < pivot) left++;
            while (left <= right && nums[right] > pivot) right--;
            if (left <= right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }
        
        quickSort(nums, start, right);
        quickSort(nums, left, end);
    }
}