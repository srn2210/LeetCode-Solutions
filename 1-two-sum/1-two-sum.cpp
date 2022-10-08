class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        unordered_map<int, int> map;
        for(int i=0; i<nums.size(); i++) {
            int t = target - nums[i];
            if(map.find(t) != map.end()) {
                return {i, map[t]};
            }
            map[nums[i]] = i;
        }
        return {};
    }
};