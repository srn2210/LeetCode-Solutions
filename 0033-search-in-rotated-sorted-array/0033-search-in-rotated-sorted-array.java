class Solution {
    public int search(int[] nums, int target) {
        if(nums.length == 1) return nums[0] == target ? 0 : -1;
        int pivot = 0;
        int lo = 0;
        int hi = nums.length-1;
        while(lo <= hi) {
            //System.out.println("lo = "+ lo + " hi = "+hi);
            int mid = (hi + lo) / 2;
            if(nums[lo] <= nums[mid] && nums[mid] <= nums[hi]) {
                pivot = lo;
                break;
            }
            else if(nums[mid] < nums[lo]) {
                hi = mid;
            }
            else {
                lo = mid+1;
            }
        }
        //System.out.println(pivot);
        int a1 = Arrays.binarySearch(nums, 0, pivot, target);
        int a2 = Arrays.binarySearch(nums, pivot, nums.length, target);
        return a1 < 0 ? a2 < 0 ? -1 : a2 : a1;
    }
}