class Solution {
    void swap(int pivot, int ind, int[] nums) {
        int t = nums[pivot];
        nums[pivot] = nums[ind];
        nums[ind] = t;
    }
    void sort(int[] nums, int left, int right) {
        if(left >= right) return;
        int pivot = (int)(Math.random()*(right-left+1))+left;
        int piv = nums[pivot];
        swap(pivot, right, nums);
        int l = left;
        int r = right-1;
        while(l<=r) {
            if(nums[l] <= piv) l++;
            else {
                swap(l, r, nums);
                r--;
            }
        }
        swap(l, right, nums);
        sort(nums, left, l-1);
        sort(nums, l+1, right);
    }
    public int[] sortArray(int[] nums) {
        sort(nums, 0, nums.length-1);
        return nums;
    }
}