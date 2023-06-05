class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        int slow = nums[0], fast = nums[nums[0]];
        while(fast != slow) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        int curr = 0;
        while(slow != curr) {
            slow = nums[slow];
            curr = nums[curr];
        }
        return curr;
    }
}