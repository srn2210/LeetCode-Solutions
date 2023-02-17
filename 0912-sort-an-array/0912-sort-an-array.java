class Solution {
    void swap(int pivot, int ind, int[] nums) {
        int t = nums[pivot];
        nums[pivot] = nums[ind];
        nums[ind] = t;
    }
    /*void sort(int[] nums, int left, int right, int pivot) {
        
    }*/
    void partition(int[] nums, int left, int right) {
        if(left >= right) return;
        int pivot = (int)(Math.random()*(right-left+1))+left;
        //sort(nums, left, right, mid);
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
        partition(nums, left, l-1);
        partition(nums, l+1, right);
    }
    public int[] sortArray(int[] nums) {
        partition(nums, 0, nums.length-1);
        return nums;
    }
}