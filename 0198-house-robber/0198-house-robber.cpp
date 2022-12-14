class Solution {
public:
    int rob(vector<int>& nums) {
        if(nums.size() == 1) return nums[0];
        if(nums.size() == 2) return max(nums[0], nums[1]);
        int t1 = nums[0];
        int t2 = max(nums[0], nums[1]);
        for(int i=2; i<nums.size(); i++) {
            int temp = t2;
            t2 = max(t2, nums[i] + t1);
            t1 = temp;
        }
        return t2;
    }
};