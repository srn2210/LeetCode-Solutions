class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        unordered_map<int, int> map;
        vector<int> ans;
        for(int i=0; i<nums.size(); i++) {
            int t = target - nums[i];
            if(map.find(t) != map.end()) {
                ans.push_back(i);
                ans.push_back(map[t]);
                break;
            }
            map[nums[i]] = i;
        }
        return ans;
    }
};