class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];
        int right = Arrays.binarySearch(nums, 0);
        right = right < 0 ? -right-1 : right;
        int left = right - 1;
        int i = 0;
        while(left >= 0 || right < nums.length) {
            if(left < 0) {
                res[i] = nums[right] * nums[right];
                i++;
                right++;
            }
            else if(right >= nums.length) {
                res[i] = nums[left] * nums[left];
                i++;
                left--;
            }
            else if(nums[right] < -nums[left]) {
                res[i] = nums[right] * nums[right];
                i++;
                right++;
            }
            else {
                res[i] = nums[left] * nums[left];
                i++;
                left--;
            }
        }
        return res;
    }
}