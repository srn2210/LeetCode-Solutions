class Solution {
    public int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;
        while(slow != fast || (slow == 0 && fast == 0)) {
            fast = nums[nums[fast]];
            slow = nums[slow];
        }
        slow = 0;
        while(slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}